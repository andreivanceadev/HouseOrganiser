package com.andreivanceadev.recipes.model.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeCategoryModel(
    val categoryType: CategoryType,
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String
) : Parcelable
