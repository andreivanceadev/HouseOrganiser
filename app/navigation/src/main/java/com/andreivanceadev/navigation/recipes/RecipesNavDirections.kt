package com.andreivanceadev.navigation.recipes

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.andreivanceadev.navigation.NavigationCommand

object RecipesDirections {

    val root = object : NavigationCommand {
        override val args: List<NamedNavArgument> = emptyList()
        override val route: String = "recipes/categories"
        override val screenTitle: String = "Recipes"
    }

    val recipesAdd = object : NavigationCommand {
        override val args: List<NamedNavArgument> = emptyList()
        override val route: String = "recipes/add"
        override val screenTitle: String = "Add recipe"
    }

    object RecipesList {
        const val KEY_CATEGORY_NAME = "categoryName"
        const val route = "recipes/list/{$KEY_CATEGORY_NAME}"

        val arguments = listOf(
            navArgument(KEY_CATEGORY_NAME) { type = NavType.StringType }
        )

        fun category(categoryName: String) = object : NavigationCommand {
            override val args = arguments
            override val route = "recipes/list/$categoryName"
            override val screenTitle: String = categoryName
        }
    }
}
