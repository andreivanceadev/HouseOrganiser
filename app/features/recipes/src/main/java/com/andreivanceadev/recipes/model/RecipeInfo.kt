package com.andreivanceadev.recipes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeInfo(
    val imageUrl: String,
    val title: String,
    val type: CategoryType,
    val description: String
) : Parcelable
