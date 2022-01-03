package com.andreivanceadev.storage

import androidx.room.TypeConverter
import com.andreivanceadev.storage.entities.recipes.CategoryTypeEntity
import com.andreivanceadev.storage.entities.recipes.IngredientEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DBTypeConverters {
    private val gson by lazy { Gson() }

    @TypeConverter
    fun fromIngredientsListToString(list: List<IngredientEntity>): String = gson.toJson(list)

    @TypeConverter
    fun fromIngredientsStringToList(value: String): List<IngredientEntity> =
        gson.fromJson(value, object : TypeToken<List<IngredientEntity>>() {}.type)

    @TypeConverter
    fun fromCategoryType(category: CategoryTypeEntity) = category.name

    @TypeConverter
    fun toCategoryType(category: String) = enumValueOf<CategoryTypeEntity>(category)
}
