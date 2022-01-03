package com.andreivanceadev.storage.entities.recipes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val recipeId: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "category") val category: CategoryTypeEntity,
    @ColumnInfo(name = "ingredients") val ingredients: List<IngredientEntity>
)
