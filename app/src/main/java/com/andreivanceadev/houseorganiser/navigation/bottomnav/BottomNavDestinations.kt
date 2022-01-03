package com.andreivanceadev.houseorganiser.navigation.bottomnav

import androidx.navigation.NamedNavArgument
import com.andreivanceadev.houseorganiser.navigation.NavigationCommand

sealed class BottomNavDestinations {

    object Recipes : NavigationCommand {
        override val route = "recipes"
        override val args: List<NamedNavArgument> = emptyList()
        override val screenTitle = "Recipes"
    }

    object Scheduler : NavigationCommand {
        override val route = "scheduler"
        override val args: List<NamedNavArgument> = emptyList()
        override val screenTitle = "Meal Plan"
    }

    object Storage : NavigationCommand {
        override val route = "storage"
        override val args: List<NamedNavArgument> = emptyList()
        override val screenTitle = "My Storage"
    }

    object ShoppingList : NavigationCommand {
        override val route = "shoppinglist"
        override val args: List<NamedNavArgument> = emptyList()
        override val screenTitle = "Shopping List"
    }

    companion object {
        fun fromRoute(route: String?): NavigationCommand {
            return when (route?.substringBefore("/")) {
                Recipes.route -> Recipes
                Scheduler.route -> Scheduler
                Storage.route -> Storage
                ShoppingList.route -> ShoppingList
                null -> Recipes
                else -> throw IllegalStateException("Invalid route $route")
            }
        }
    }
}
