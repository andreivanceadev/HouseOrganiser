package com.andreivanceadev.recipes.model.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IngredientModel(
    val name: String,
    val quantity: Float,
    val measure: MeasureModel,
    val instructions: String
) : Parcelable
