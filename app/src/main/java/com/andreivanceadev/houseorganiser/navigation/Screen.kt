package com.andreivanceadev.houseorganiser.navigation

sealed class Screen(val route: String, val title: String) {
    object Recipes : Screen("recipes", "Recipes")
    object RecipeAdd : Screen("recipes/add", "Add a new recipe")
    object RecipesList : Screen("recipes/list", "Recipes")

    object Scheduler : Screen("scheduler", "Meal Plan")
    object Storage : Screen("storage", "My Storage")
    object ShoppingList : Screen("shoppinglist", "Shopping List")
}
