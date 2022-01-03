package com.andreivanceadev.houseorganiser.navigation

import androidx.annotation.DrawableRes
import com.andreivanceadev.houseorganiser.navigation.bottomnav.BottomNavDestinations
import com.andreivanceadev.recipes.R

sealed class BottomNavigationItem(val navDestination: NavigationCommand, @DrawableRes val imageId: Int, val title: String) {
    object Recipes : BottomNavigationItem(BottomNavDestinations.Recipes, R.drawable.ic_recipes, "Recipes")
    object Scheduler : BottomNavigationItem(BottomNavDestinations.Scheduler, R.drawable.ic_schedule, "Planner")
    object Storage : BottomNavigationItem(BottomNavDestinations.Storage, R.drawable.ic_storage, "Storage")
    object ShoppingList : BottomNavigationItem(BottomNavDestinations.ShoppingList, R.drawable.ic_shopping_cart, "Cart")
}
