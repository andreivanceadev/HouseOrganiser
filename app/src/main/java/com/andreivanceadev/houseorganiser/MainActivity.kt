package com.andreivanceadev.houseorganiser

import android.os.Bundle
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreivanceadev.houseorganiser.navigation.AppNavigator
import com.andreivanceadev.houseorganiser.navigation.NavigationItem
import com.andreivanceadev.houseorganiser.navigation.Screen
import com.andreivanceadev.houseorganiser.navigation.TopBarController
import com.andreivanceadev.houseorganiser.style.AppTheme
import com.andreivanceadev.recipes.RecipesListScreen
import com.andreivanceadev.recipes.RecipesScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigatorFactory: AppNavigator.Factory

    private var toolbarTitle = mutableStateOf("Recipes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val topBarController = object : TopBarController {
                    override fun configToolbar(title: String) {
                        toolbarTitle.value = title
                    }
                }
                HouseOrganiserApp(navigatorFactory.create(rememberNavController(), topBarController))
            }
        }
    }

    @Composable
    fun HouseOrganiserApp(appNavigator: AppNavigator) {
        val navController = appNavigator.navController
        val navStackBackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navStackBackEntry.value?.destination?.route

        val navBarItems = listOf(
            NavigationItem.Recipes,
            NavigationItem.Scheduler,
            NavigationItem.Storage,
            NavigationItem.ShoppingList
        )

        Scaffold(
            topBar = {
                TopBar(toolbarTitle.value)
            },
            bottomBar = {
                BottomNavBar(
                    items = navBarItems,
                    currentRoute = currentRoute,
                    onClick = {
                        appNavigator.bottomNavBarNavigation(it)
                    }
                )
            },
            floatingActionButton =
            getFabForScreen(currentRoute = currentRoute) { route ->
                appNavigator.fabNavigation(route = route)
            }
        ) { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = Screen.Recipes.route
            ) {
                composable(route = Screen.Recipes.route) {
                    RecipesScreen(recipesNavigation = appNavigator)
                }
                composable(route = Screen.Scheduler.route) {
                    ScreenPlaceholder(title = "Scheduler")
                }
                composable(route = Screen.Storage.route) {
                    ScreenPlaceholder(title = "Storage")
                }
                composable(route = Screen.ShoppingList.route) {
                    ScreenPlaceholder(title = "ShoppingList")
                }
                composable(route = Screen.RecipeAdd.route) {
                    ScreenPlaceholder(title = "Add Recipe")
                }
                composable(route = Screen.RecipesList.route) {
                    RecipesListScreen(recipesNavigation = appNavigator)
                }
            }
        }
    }

    private fun getFabForScreen(currentRoute: String?, onClick: (route: String) -> Unit): @Composable () -> Unit {
        if (currentRoute == Screen.RecipesList.route) {
            return {
                FabAddItems {
                    onClick(Screen.RecipeAdd.route)
                }
            }
        }
        return {}
    }

    @Composable
    private fun FabAddItems(onClick: () -> Unit) {
        FloatingActionButton(onClick = onClick) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
        }
    }

    @Composable
    fun TopBar(title: String) {
        TopAppBar(
            title = { Text(text = title) }
        )
    }

    @Composable
    fun BottomNavBar(
        items: List<NavigationItem>,
        currentRoute: String?,
        onClick: (route: String) -> Unit
    ) {
        BottomNavigation {

            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painter = painterResource(id = item.imageId), contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selected = currentRoute?.startsWith(item.route) ?: false,
                    onClick = { onClick(item.route) }
                )
            }
        }
    }

    @Composable
    fun ScreenPlaceholder(title: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.h5)
        }
    }
}
