package com.andreivanceadev.houseorganiser

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.andreivanceadev.houseorganiser.navigation.AppNavigator
import com.andreivanceadev.houseorganiser.navigation.BottomNavigationItem
import com.andreivanceadev.houseorganiser.style.AppTheme
import com.andreivanceadev.navigation.bottomnav.BottomNavDestinations
import com.andreivanceadev.navigation.recipes.RecipesDirections
import com.andreivanceadev.recipes.view.RecipesListScreen
import com.andreivanceadev.recipes.view.RecipesScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigatorFactory: AppNavigator.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Log.d("Composition", "AppTheme{}")
                HouseOrganiserApp(navigatorFactory.create(rememberNavController()))
            }
        }
    }
}

@Composable
fun HouseOrganiserApp(navigator: AppNavigator) {

    Log.d("Composition", "HouseOrganiserApp()")

    val navBarItems = listOf(
        BottomNavigationItem.Recipes,
        BottomNavigationItem.Scheduler,
        BottomNavigationItem.Storage,
        BottomNavigationItem.ShoppingList
    )

    Log.d("Composition", "AppView()")
    val navController = navigator.navController

    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = BottomNavDestinations.fromRoute(backstackEntry.value?.destination?.route)
    val showFab =
        currentRoute == BottomNavDestinations.Recipes &&
            backstackEntry.value?.destination?.route != RecipesDirections.recipesAdd.route

    Scaffold(
        topBar = {
            TopBar(title = currentRoute.screenTitle)
            Log.d("Composition", "TopBar()")
        },
        bottomBar = {
            BottomNavBar(
                navController = navController,
                items = navBarItems
            )
        },
        floatingActionButton = {
            if (showFab) {
                FabAddItems {
                    navController.navigate(RecipesDirections.recipesAdd.route)
                }
            }
            Log.d("Composition", "Fab()")
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = BottomNavDestinations.Recipes.route
        ) {
            navigation(
                startDestination = RecipesDirections.root.route,
                route = BottomNavDestinations.Recipes.route,
            ) {
                composable(route = RecipesDirections.root.route) {
                    RecipesScreen(
                        recipesNavigator = navigator
                    )
                }
                composable(
                    route = RecipesDirections.RecipesList.route,
                    arguments = RecipesDirections.RecipesList.arguments
                ) {
                    RecipesListScreen()
                }
                composable(route = RecipesDirections.recipesAdd.route) {
                    ScreenPlaceholder(title = "Add Recipe")
                }
            }

            composable(route = BottomNavDestinations.Scheduler.route) {
                ScreenPlaceholder(title = "Scheduler")
            }
            composable(route = BottomNavDestinations.Storage.route) {
                ScreenPlaceholder(title = "Storage")
            }
            composable(route = BottomNavDestinations.ShoppingList.route) {
                ScreenPlaceholder(title = "ShoppingList")
            }
        }
    }
}

@Composable
private fun FabAddItems(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
    }
}

@Composable
private fun TopBar(title: String) {
    TopAppBar(
        title = { Text(text = title) }
    )
}

@Composable
private fun BottomNavBar(
    navController: NavHostController,
    items: List<BottomNavigationItem>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    currentDestination ?: return

    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.imageId), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentDestination.hierarchy.any { it.route == item.navDestination.route },
                onClick = {
                    navController.navigate(item.navDestination.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }

    Log.d("Composition", "BottomNavBar()")
}

@Composable
private fun ScreenPlaceholder(title: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title, style = MaterialTheme.typography.h5)
    }
}
