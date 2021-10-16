package com.andreivanceadev.houseorganiser.navigation

sealed class Screen(val route: String) {

    object Recipes : Screen("recipes")
    object RecipeAdd : Screen("recipes/add")
    object RecipesList : Screen("recipes/list")

    object Scheduler : Screen("scheduler")
    object Storage : Screen("storage")
    object ShoppingList : Screen("shoppinglist")
}
