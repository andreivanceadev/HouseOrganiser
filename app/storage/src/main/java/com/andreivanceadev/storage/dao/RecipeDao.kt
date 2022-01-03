package com.andreivanceadev.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.andreivanceadev.storage.entities.recipes.RecipeEntity

@Dao
interface RecipeDao {

    @Query("SELECT * from recipes")
    suspend fun getAll(): List<RecipeEntity>?

    @Query("SELECT * from recipes WHERE recipeId = :recipeId LIMIT 1")
    suspend fun getById(recipeId: Int): RecipeEntity?

    @Insert
    suspend fun insert(recipe: RecipeEntity)

    @Insert
    suspend fun insertAll(recipes: List<RecipeEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun update(recipe: RecipeEntity)

    @Delete
    suspend fun delete(recipe: RecipeEntity)
}
