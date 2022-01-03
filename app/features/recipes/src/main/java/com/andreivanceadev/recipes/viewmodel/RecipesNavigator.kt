package com.andreivanceadev.recipes.viewmodel

import com.andreivanceadev.recipes.model.models.CategoryType

interface RecipesNavigator {
    fun recipesDashboardToCategoryView(category: CategoryType)
}
