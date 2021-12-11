package com.andreivanceadev.storage.datasource

import com.andreivanceadev.storage.dao.RecipeDao
import com.andreivanceadev.storage.entities.recipes.RecipeEntity
import javax.inject.Inject

class RecipesDataSource @Inject constructor(
    private val recipesDao: RecipeDao
) {

    suspend fun getRecipes() = recipesDao.getAll()

    suspend fun getRecipe(recipeId: Int) = recipesDao.getById(recipeId)

    suspend fun saveRecipe(recipeEntity: RecipeEntity) = recipesDao.insert(recipeEntity)

    suspend fun updateRecipe(recipeEntity: RecipeEntity) = recipesDao.update(recipeEntity)

    suspend fun deleteRecipe(recipeEntity: RecipeEntity) = recipesDao.delete(recipeEntity)
}
