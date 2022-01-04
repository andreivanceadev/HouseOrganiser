package com.andreivanceadev.recipes.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreivanceadev.common.theme.Dimens
import com.andreivanceadev.common.theme.TransparentBlack_x87
import com.andreivanceadev.recipes.R
import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.viewmodel.RecipesNavigator
import com.andreivanceadev.recipes.viewmodel.RecipesViewModel
import com.andreivanceadev.recipes.viewmodel.RecipesViewState
import com.andreivanceadev.recipes.viewmodel.ShowCategory
import kotlinx.coroutines.flow.collect

const val RECIPE_CATEGORY_TEST_TAG = "recipeCategoryTestTag"

@Composable
fun RecipesScreen(
    viewModel: RecipesViewModel = hiltViewModel(),
    recipesNavigator: RecipesNavigator
) {

    val viewState = viewModel.container.stateFlow.collectAsState()

    RecipesView(
        viewState = remember { getMockedViewState() },
        onRecipeCategoryClick = { categoryName ->
            viewModel.onMoveToRecipesList(categoryName)
        }
    )

    LaunchedEffect(key1 = null) {
        viewModel.container.sideEffectFlow.collect { sideEffect ->
            when (sideEffect) {
                is ShowCategory -> {
                    recipesNavigator.recipesDashboardToCategoryView(sideEffect.category)
                }
            }
        }
    }
}

@Composable
fun RecipesView(
    viewState: RecipesViewState,
    onRecipeCategoryClick: (category: CategoryType) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(Dimens.space_x1)
    ) {
        LazyColumn {
            items(viewState.categories) { recipeCategory ->
                Spacer(modifier = Modifier.height(Dimens.space_half))
                RecipeCategory(
                    categoryType = recipeCategory.categoryType,
                    imageId = recipeCategory.imageId,
                    label = recipeCategory.title,
                    description = recipeCategory.description,
                    onClick = { onRecipeCategoryClick(recipeCategory.categoryType) }
                )
                Spacer(modifier = Modifier.height(Dimens.space_x1))
            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipeCategory() {
    RecipeCategory(
        categoryType = CategoryType.BREAKFAST,
        imageId = R.drawable.breakfast,
        label = "Breakfast",
        description = "Just a description",
        onClick = {}
    )
}

@Composable
fun RecipeCategory(
    categoryType: CategoryType,
    @DrawableRes imageId: Int,
    label: String,
    description: String,
    onClick: (categoryName: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .testTag(RECIPE_CATEGORY_TEST_TAG),
        shape = RoundedCornerShape(Dimens.space_quarter)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            onClick = { onClick(categoryType.categoryName) }
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(id = imageId),
                    contentDescription = "label"
                )
                Column(
                    modifier = Modifier
                        .padding(start = Dimens.space_x1)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                bottom = Dimens.space_half
                            )
                            .fillMaxWidth(),
                        text = label,
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = Dimens.space_x1)
                            .fillMaxWidth(),
                        text = description,
                        style = MaterialTheme.typography.subtitle2,
                        color = TransparentBlack_x87,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
