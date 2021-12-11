package com.andreivanceadev.storage.entities.recipes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IngredientEntity(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "quantity") val quantity: Float,
    @ColumnInfo(name = "measure") val measure: MeasureEntity,
    // diced, fried, or other instructions for ingredients
    @ColumnInfo(name = "instructions") val instructions: String
)
