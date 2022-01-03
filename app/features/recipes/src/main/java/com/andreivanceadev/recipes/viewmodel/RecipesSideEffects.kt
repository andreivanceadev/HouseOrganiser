package com.andreivanceadev.recipes.viewmodel

import com.andreivanceadev.recipes.model.models.CategoryType

sealed interface RecipesSideEffects

class ShowCategory(val category: CategoryType) : RecipesSideEffects
