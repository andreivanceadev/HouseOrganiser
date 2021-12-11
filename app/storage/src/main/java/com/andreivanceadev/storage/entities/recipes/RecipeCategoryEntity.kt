package com.andreivanceadev.storage.entities.recipes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_category")
data class RecipeCategoryEntity(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "name") val name: String
)
