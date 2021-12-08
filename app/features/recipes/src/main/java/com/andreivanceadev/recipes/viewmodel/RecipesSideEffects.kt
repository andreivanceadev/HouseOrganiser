package com.andreivanceadev.recipes.viewmodel

sealed interface RecipesSideEffects

class ShowCategory(val category: String) : RecipesSideEffects
