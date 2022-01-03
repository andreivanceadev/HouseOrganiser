package com.andreivanceadev.recipes.viewmodel

import android.os.Parcelable
import com.andreivanceadev.recipes.model.models.RecipeCategoryModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesViewState(
    val categories: List<RecipeCategoryModel> = emptyList()
) : Parcelable
