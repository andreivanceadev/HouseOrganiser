package com.andreivanceadev.recipes.list.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andreivanceadev.navigation.recipes.RecipesDirections
import com.andreivanceadev.recipes.list.model.breakfastRecipeInfoListMock
import com.andreivanceadev.recipes.list.model.dinnerRecipeInfoListMock
import com.andreivanceadev.recipes.list.model.lunchRecipeInfoListMock
import com.andreivanceadev.recipes.list.model.snackRecipeInfoListMock
import com.andreivanceadev.recipes.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ContainerHost<RecipesListViewState, Nothing>, ViewModel() {

    override val container: Container<RecipesListViewState, Nothing> = container(
        initialState = RecipesListViewState(),
        savedStateHandle = savedStateHandle
    ) {
        val categoryName = savedStateHandle.get<String>(RecipesDirections.RecipesList.KEY_CATEGORY_NAME)
        loadListOfRecipes(categoryName ?: "invalid")
    }

    private fun loadListOfRecipes(categoryName: String) = intent {
        // repository.getListOfRecipes(categoryId)
        reduce {
            state.copy(
                recipesList = when (CategoryType.getByName(categoryName)) {
                    CategoryType.BREAKFAST -> breakfastRecipeInfoListMock
                    CategoryType.LUNCH -> lunchRecipeInfoListMock
                    CategoryType.DINNER -> dinnerRecipeInfoListMock
                    CategoryType.SNACK -> snackRecipeInfoListMock
                }
            )
        }
    }
}
