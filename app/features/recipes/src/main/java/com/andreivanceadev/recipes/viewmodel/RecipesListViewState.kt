package com.andreivanceadev.recipes.viewmodel

import android.os.Parcelable
import com.andreivanceadev.recipes.model.RecipeInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesListViewState(
    val recipesList: List<RecipeInfo> = emptyList()
) : Parcelable
