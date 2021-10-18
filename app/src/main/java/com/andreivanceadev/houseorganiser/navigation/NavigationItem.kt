package com.andreivanceadev.houseorganiser.navigation

import androidx.annotation.DrawableRes
import com.andreivanceadev.recipes.R

sealed class NavigationItem(val route: String, @DrawableRes val imageId: Int, val title: String) {
    object Recipes : NavigationItem("recipes", R.drawable.ic_recipes, "Recipes")
    object Scheduler : NavigationItem("scheduler", R.drawable.ic_schedule, "Planner")
    object Storage : NavigationItem("storage", R.drawable.ic_storage, "Storage")
    object ShoppingList : NavigationItem("shoppinglist", R.drawable.ic_shopping_cart, "Cart")
}
