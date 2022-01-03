package com.andreivanceadev.houseorganiser.navigation.recipes

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.andreivanceadev.houseorganiser.navigation.NavigationCommand
import com.andreivanceadev.recipes.model.models.CategoryType

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
        private const val KEY_CATEGORY_NAME = "categoryName"
        const val route = "recipes/list/{$KEY_CATEGORY_NAME}"

        val arguments = listOf(
            navArgument(KEY_CATEGORY_NAME) { type = NavType.StringType }
        )

        fun category(category: CategoryType) = object : NavigationCommand {
            override val args = arguments
            override val route = "recipes/list/${category.categoryName}"
            override val screenTitle: String = category.categoryName
        }
    }
}
