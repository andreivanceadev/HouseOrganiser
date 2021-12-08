package com.andreivanceadev.recipes.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeCategoryInfo(
    val categoryType: CategoryType,
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String
) : Parcelable
