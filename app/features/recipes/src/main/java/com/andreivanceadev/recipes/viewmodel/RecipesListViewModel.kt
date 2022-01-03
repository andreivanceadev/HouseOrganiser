package com.andreivanceadev.recipes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.model.models.RecipeModel
import com.andreivanceadev.recipes.model.models.breakfastRecipeInfoListMock
import com.andreivanceadev.recipes.model.models.dinnerRecipeInfoListMock
import com.andreivanceadev.recipes.model.models.lunchRecipeInfoListMock
import com.andreivanceadev.recipes.model.models.snackRecipeInfoListMock
import com.andreivanceadev.recipes.model.repository.RecipesRepository
import com.andreivanceadev.recipes.model.repository.mappers.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val recipesRepository: RecipesRepository
) : ContainerHost<RecipesListViewState, Nothing>, ViewModel() {

    override val container: Container<RecipesListViewState, Nothing> = container(
        initialState = RecipesListViewState(),
        savedStateHandle = savedStateHandle
    ) {
        val categoryName = savedStateHandle.get<String>(KEY_CATEGORY_NAME)
        categoryName?.let {
            loadListOfRecipes(CategoryType.getByName(it))
        }
    }

    private fun loadListOfRecipes(categoryType: CategoryType) = intent {
        var recipes = recipesRepository.getRecipes(categoryType)

        recipes = prepopulateDatabaseForDebug(recipes, categoryType)

        reduce {
            state.copy(
                recipesList = recipes
            )
        }
    }

    private suspend fun prepopulateDatabaseForDebug(
        recipes: List<RecipeModel>,
        categoryType: CategoryType
    ): List<RecipeModel> {
        var recipes1 = recipes
        if (recipes1.isEmpty()) {
            recipes1 = breakfastRecipeInfoListMock +
                lunchRecipeInfoListMock +
                dinnerRecipeInfoListMock +
                snackRecipeInfoListMock

            recipesRepository.addRecipes(recipes1.map { it.toEntity() })
        }
        recipes1 = recipes1.filter { it.type == categoryType }
        return recipes1
    }

    companion object {
        private const val KEY_CATEGORY_NAME = "categoryName"
    }
}
