package com.andreivanceadev.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreivanceadev.storage.entities.recipes.RecipeCategoryEntity

@Dao
interface RecipeCategoryDao {

    @Query("SELECT * from recipe_category")
    suspend fun getAll(): List<RecipeCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: RecipeCategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(category: RecipeCategoryEntity)

    @Delete
    suspend fun delete(category: RecipeCategoryEntity)
}
