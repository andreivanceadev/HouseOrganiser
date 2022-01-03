package com.andreivanceadev.recipes.model.repository.mappers

import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.model.models.IngredientModel
import com.andreivanceadev.recipes.model.models.MeasureModel
import com.andreivanceadev.recipes.model.models.RecipeModel
import com.andreivanceadev.storage.entities.recipes.CategoryTypeEntity
import com.andreivanceadev.storage.entities.recipes.IngredientEntity
import com.andreivanceadev.storage.entities.recipes.MeasureEntity
import com.andreivanceadev.storage.entities.recipes.RecipeEntity

fun List<RecipeEntity>.toDomainModel() = this.map {
    RecipeModel(
        imageUrl = "", // TODO: 11.12.2021 Don't forget about recipe image
        title = it.title,
        type = it.category.toDomainModel(),
        instructions = it.instructions,
        ingredients = it.ingredients.map { ingredient -> ingredient.toDomainModel() }
    )
}

fun IngredientEntity.toDomainModel() = IngredientModel(
    name = this.name,
    quantity = this.quantity,
    measure = this.measure.toDomainModel(),
    instructions = this.instructions
)

fun MeasureEntity.toDomainModel() = when (this) {
    MeasureEntity.CUP -> MeasureModel.CUP
    MeasureEntity.GRAM -> MeasureModel.GRAM
    MeasureEntity.KILOGRAM -> MeasureModel.KILOGRAM
    MeasureEntity.OUNCE -> MeasureModel.OUNCE
    MeasureEntity.TABLESPOON -> MeasureModel.TABLESPOON
    MeasureEntity.TEASPOON -> MeasureModel.TEASPOON
}

fun CategoryTypeEntity.toDomainModel() =
    when (this) {
        CategoryTypeEntity.BREAKFAST -> CategoryType.BREAKFAST
        CategoryTypeEntity.LUNCH -> CategoryType.LUNCH
        CategoryTypeEntity.DINNER -> CategoryType.DINNER
        CategoryTypeEntity.SNACK -> CategoryType.SNACK
    }

// DomainToEntity
fun RecipeModel.toEntity() = RecipeEntity(
    title = this.title,
    instructions = this.instructions,
    category = this.type.toEntity(),
    ingredients = this.ingredients.map { it.toEntity() }
)

fun CategoryType.toEntity() = when (this) {
    CategoryType.BREAKFAST -> CategoryTypeEntity.BREAKFAST
    CategoryType.LUNCH -> CategoryTypeEntity.LUNCH
    CategoryType.DINNER -> CategoryTypeEntity.DINNER
    CategoryType.SNACK -> CategoryTypeEntity.SNACK
}

fun IngredientModel.toEntity() = IngredientEntity(
    name = this.name,
    quantity = this.quantity,
    measure = this.measure.toEntity(),
    instructions = this.instructions
)

fun MeasureModel.toEntity() = when (this) {
    MeasureModel.CUP -> MeasureEntity.CUP
    MeasureModel.GRAM -> MeasureEntity.GRAM
    MeasureModel.KILOGRAM -> MeasureEntity.KILOGRAM
    MeasureModel.OUNCE -> MeasureEntity.OUNCE
    MeasureModel.TABLESPOON -> MeasureEntity.TABLESPOON
    MeasureModel.TEASPOON -> MeasureEntity.TEASPOON
}
