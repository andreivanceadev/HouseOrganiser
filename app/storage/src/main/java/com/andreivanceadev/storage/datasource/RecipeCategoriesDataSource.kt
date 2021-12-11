package com.andreivanceadev.storage.datasource

import com.andreivanceadev.storage.dao.RecipeCategoryDao
import com.andreivanceadev.storage.entities.recipes.RecipeCategoryEntity
import javax.inject.Inject

class RecipeCategoriesDataSource @Inject constructor(
    private val recipeCategoryDao: RecipeCategoryDao
) {

    suspend fun getCategories() = recipeCategoryDao.getAll()

    suspend fun saveCategory(categoryEntity: RecipeCategoryEntity) = recipeCategoryDao.insert(categoryEntity)

    suspend fun updateCategory(categoryEntity: RecipeCategoryEntity) = recipeCategoryDao.update(categoryEntity)

    suspend fun deleteCategory(categoryEntity: RecipeCategoryEntity) = recipeCategoryDao.delete(categoryEntity)
}
