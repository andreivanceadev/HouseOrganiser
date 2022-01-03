package com.andreivanceadev.houseorganiser.navigation

import androidx.navigation.NavHostController
import com.andreivanceadev.houseorganiser.navigation.recipes.RecipesDirections
import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.viewmodel.RecipesNavigator
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class AppNavigator @AssistedInject constructor(
    @Assisted val navController: NavHostController,
) : RecipesNavigator {

    @AssistedFactory
    interface Factory {
        fun create(navController: NavHostController): AppNavigator
    }

    override fun recipesDashboardToCategoryView(category: CategoryType) {
        navController.navigate(RecipesDirections.RecipesList.category(category).route)
    }
}
