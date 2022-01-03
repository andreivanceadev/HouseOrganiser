package com.andreivanceadev.recipes.model.repository

import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.model.models.RecipeModel
import com.andreivanceadev.recipes.model.repository.mappers.toDomainModel
import com.andreivanceadev.storage.datasource.RecipesDataSource
import com.andreivanceadev.storage.entities.recipes.RecipeEntity
import java.util.Collections.emptyList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipesRepository @Inject constructor(
    private val recipesDataSource: RecipesDataSource
) {

    suspend fun getRecipes() = recipesDataSource.getRecipes()?.toDomainModel()

    suspend fun getRecipes(categoryType: CategoryType): List<RecipeModel> {
        val cachedRecipes = recipesDataSource.getRecipes()?.toDomainModel()
        return cachedRecipes?.filter { it.type == categoryType } ?: emptyList()
    }

    suspend fun addRecipe(recipeEntity: RecipeEntity) {
        recipesDataSource.saveRecipe(recipeEntity)
    }

    suspend fun addRecipes(recipes: List<RecipeEntity>) {
        recipesDataSource.saveRecipes(recipes)
    }
}
