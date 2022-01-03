package com.andreivanceadev.recipes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andreivanceadev.recipes.model.models.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ContainerHost<RecipesViewState, RecipesSideEffects>, ViewModel() {

    override val container = container<RecipesViewState, RecipesSideEffects>(
        initialState = RecipesViewState(),
        savedStateHandle = savedStateHandle
    ) {
    }

    fun onMoveToRecipesList(categoryType: CategoryType) = intent {
        postSideEffect(ShowCategory(categoryType))
    }
}
