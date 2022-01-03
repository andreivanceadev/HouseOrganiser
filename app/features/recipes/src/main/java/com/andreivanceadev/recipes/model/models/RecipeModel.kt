package com.andreivanceadev.recipes.model.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeModel(
    val id: Int = -1,
    val imageUrl: String,
    val title: String,
    val type: CategoryType,
    val instructions: String,
    val ingredients: List<IngredientModel>
) : Parcelable
