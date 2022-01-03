package com.andreivanceadev.recipes.viewmodel

import android.os.Parcelable
import com.andreivanceadev.recipes.model.models.RecipeModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesListViewState(
    val recipesList: List<RecipeModel> = emptyList()
) : Parcelable
