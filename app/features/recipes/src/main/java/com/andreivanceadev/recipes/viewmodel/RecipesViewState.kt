package com.andreivanceadev.recipes.viewmodel

import android.os.Parcelable
import com.andreivanceadev.recipes.model.RecipeCategoryInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesViewState(
    val categories: List<RecipeCategoryInfo> = emptyList()
) : Parcelable
