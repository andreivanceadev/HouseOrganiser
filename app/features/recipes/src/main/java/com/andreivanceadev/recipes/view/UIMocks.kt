package com.andreivanceadev.recipes.view

import com.andreivanceadev.recipes.R
import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.model.models.RecipeCategoryModel
import com.andreivanceadev.recipes.viewmodel.RecipesViewState

fun getMockedViewState() = RecipesViewState(
    categories = listOf(
        RecipeCategoryModel(CategoryType.BREAKFAST, R.drawable.breakfast, "Breakfast", "This is just breakfast"),
        RecipeCategoryModel(CategoryType.LUNCH, R.drawable.lunch, "Lunch", "This is just for lunch"),
        RecipeCategoryModel(CategoryType.DINNER, R.drawable.breakfast, "Dinner", "This is just for Dinner"),
        RecipeCategoryModel(CategoryType.SNACK, R.drawable.snack, "Snacks", "This is just for snacks")
    )
)
