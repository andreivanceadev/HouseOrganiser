package com.andreivanceadev.recipes

import com.andreivanceadev.recipes.model.CategoryType
import com.andreivanceadev.recipes.model.RecipeCategoryInfo
import com.andreivanceadev.recipes.viewmodel.RecipesViewState

fun getMockedViewState() = RecipesViewState(
    categories = listOf(
        RecipeCategoryInfo(CategoryType.BREAKFAST, R.drawable.breakfast, "Breakfast", "This is just breakfast"),
        RecipeCategoryInfo(CategoryType.LUNCH, R.drawable.lunch, "Lunch", "This is just for lunch"),
        RecipeCategoryInfo(CategoryType.DINNER, R.drawable.breakfast, "Dinner", "This is just for Dinner"),
        RecipeCategoryInfo(CategoryType.SNACK, R.drawable.snack, "Snacks", "This is just for snacks")
    )
)
