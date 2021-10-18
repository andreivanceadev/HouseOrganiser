package com.andreivanceadev.recipes

import com.andreivanceadev.recipes.model.RecipeCategoryInfo
import com.andreivanceadev.recipes.model.RecipeInfo

fun getMockedCategoryList() = listOf(
    RecipeCategoryInfo(1, R.drawable.breakfast, "Breakfast", "This is just breakfast"),
    RecipeCategoryInfo(2, R.drawable.lunch, "Lunch", "This is just for lunch"),
    RecipeCategoryInfo(3, R.drawable.breakfast, "Dinner", "This is just for Dinner"),
    RecipeCategoryInfo(4, R.drawable.snack, "Snacks", "This is just for snacks")
)

val breakfastRecipeInfoListMock = listOf(
    RecipeInfo(
        imageUrl = "",
        title = "Pouched eggs",
        type = "Breakfast",
        description = "This is something good to eat. Good luck, check it out"
    ),
    RecipeInfo(
        imageUrl = "",
        title = "Scrambled eggs",
        type = "Breakfast",
        description = "This is something good to eat. Good luck, check it out"
    ),
    RecipeInfo(
        imageUrl = "",
        title = "Porridge",
        type = "Breakfast",
        description = "This is something good to eat. Good luck, check it out"
    ),
    RecipeInfo(
        imageUrl = "",
        title = "Smoothie",
        type = "Breakfast",
        description = "This is something good to eat. Good luck, check it out"
    )
)
