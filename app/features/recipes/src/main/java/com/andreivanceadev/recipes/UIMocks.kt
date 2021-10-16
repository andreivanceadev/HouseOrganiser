package com.andreivanceadev.recipes

import com.andreivanceadev.recipes.model.RecipeCategoryInfo

fun getMockedCategoryList() = listOf(
    RecipeCategoryInfo(1, R.drawable.breakfast, "Breakfast", "This is just breakfast"),
    RecipeCategoryInfo(2, R.drawable.lunch, "Lunch", "This is just for lunch"),
    RecipeCategoryInfo(3, R.drawable.breakfast, "Dinner", "This is just for Dinner"),
    RecipeCategoryInfo(4, R.drawable.snack, "Snacks", "This is just for snacks")
)
