package com.andreivanceadev.houseorganiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreivanceadev.houseorganiser.navigation.Screen
import com.andreivanceadev.houseorganiser.style.AppTheme
import com.andreivanceadev.recipes.RecipesScreen
import com.andreivanceadev.recipes.navigation.NavigationItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                HouseOrganiserApp()
            }
        }
    }

    @Composable
    fun HouseOrganiserApp() {
        val navController = rememberNavController()
        val navStackBackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navStackBackEntry.value?.destination?.route

        val items = listOf(
            NavigationItem.Recipes,
            NavigationItem.Scheduler,
            NavigationItem.Storage,
            NavigationItem.ShoppingList
        )

        Scaffold(
            topBar = {
                TopBar(
                    items.find { it.route == currentRoute }?.title ?: ""
                )
            },
            bottomBar = {
                BottomNavBar(
                    items = items,
                    currentRoute = currentRoute,
                    onClick = {
                        navController.navigate(it) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            },
            floatingActionButton =
            getFabForScreen(currentRoute = currentRoute) { route ->
                navController.navigate(route = route)
            }

        ) {
            NavHost(navController = navController, startDestination = Screen.Recipes.route) {
                composable(route = Screen.Recipes.route) {
                    RecipesScreen()
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
