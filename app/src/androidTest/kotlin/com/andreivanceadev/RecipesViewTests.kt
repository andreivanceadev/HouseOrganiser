package com.andreivanceadev

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.andreivanceadev.houseorganiser.R
import com.andreivanceadev.houseorganiser.style.AppTheme
import com.andreivanceadev.recipes.model.models.CategoryType
import com.andreivanceadev.recipes.model.models.RecipeCategoryModel
import com.andreivanceadev.recipes.view.RECIPE_CATEGORY_TEST_TAG
import com.andreivanceadev.recipes.view.RecipesView
import com.andreivanceadev.recipes.viewmodel.RecipesViewState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RecipesViewTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRecipeCategoryIsDisplayedCorrectly() {
        // Start the app
        composeTestRule.setContent {
            AppTheme {
                RecipesView(
                    viewState = RecipesViewState(
                        listOf(
                            RecipeCategoryModel(
                                CategoryType.BREAKFAST,
                                R.drawable.breakfast,
                                "title",
                                "description"
                            )
                        )
                    ),
                    onRecipeCategoryClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(RECIPE_CATEGORY_TEST_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(RECIPE_CATEGORY_TEST_TAG).assertHeightIsEqualTo(80.dp)
        composeTestRule.onNodeWithTag(RECIPE_CATEGORY_TEST_TAG).onChild().assertHasClickAction()
    }

    @Test
    fun testCategoriesAreShownCorrectly() {
        composeTestRule.setContent {
            AppTheme {
                RecipesView(
                    viewState = RecipesViewState(
                        mockedCategoryList
                    ),
                    onRecipeCategoryClick = {}
                )
            }
        }

        composeTestRule.onAllNodesWithTag(RECIPE_CATEGORY_TEST_TAG).assertCountEquals(mockedCategoryList.size)
        composeTestRule.onAllNodesWithTag(RECIPE_CATEGORY_TEST_TAG).printToLog("TAG")
    }

    private val mockedCategoryList =
        listOf(
            RecipeCategoryModel(
                CategoryType.BREAKFAST,
                R.drawable.breakfast,
                "breakfast",
                "description of breakfast"
            ),
            RecipeCategoryModel(
                CategoryType.LUNCH,
                R.drawable.lunch,
                "lunch",
                "description of lunch"
            ),
            RecipeCategoryModel(
                CategoryType.DINNER,
                R.drawable.breakfast,
                "dinner",
                "description of dinner"
            ),
            RecipeCategoryModel(
                CategoryType.SNACK,
                R.drawable.snack,
                "snack",
                "description of snack"
            )
        )
}
