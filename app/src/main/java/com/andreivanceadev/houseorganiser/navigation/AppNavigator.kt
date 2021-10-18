package com.andreivanceadev.houseorganiser.navigation

import androidx.navigation.NavHostController
import com.andreivanceadev.recipes.navigation.RecipesNavigation
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class AppNavigator @AssistedInject constructor(
    @Assisted val navController: NavHostController,
    @Assisted val topBarController: TopBarController
) : RecipesNavigation {

    init {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            updateScreenName(destination.route ?: "")
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(navController: NavHostController, topBarController: TopBarController): AppNavigator
    }

    override fun moveToRecipesList(categoryName: String) {
        navController.navigate(Screen.RecipesList.route)
        updateScreenName(categoryName, true)
    }

    fun bottomNavBarNavigation(route: String) {
        navController.navigate(route) {
            navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun fabNavigation(route: String) {
        navController.navigate(route)
    }

    private fun updateScreenName(currentRoute: String, override: Boolean = false) {
        val screenName = currentRoute.let { screens.find { it.route == currentRoute }?.title } ?: ""
        if (screenName.isNotEmpty() || override) {
            topBarController.configToolbar(
                if (override)
                    currentRoute
                else
                    screenName
            )
        }
    }

    private val screens = listOf(
        Screen.Recipes,
        Screen.RecipeAdd,
        Screen.RecipesList,
        Screen.Scheduler,
        Screen.Storage,
        Screen.ShoppingList
    )
}
