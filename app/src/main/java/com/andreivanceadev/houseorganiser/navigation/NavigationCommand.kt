package com.andreivanceadev.houseorganiser.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val args: List<NamedNavArgument>
    val route: String
    val screenTitle: String
}
