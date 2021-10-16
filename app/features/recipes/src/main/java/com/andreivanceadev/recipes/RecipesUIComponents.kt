package com.andreivanceadev.recipes

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreivanceadev.common.theme.Dimens
import com.andreivanceadev.common.theme.TransparentBlack_x87

@Composable
fun RecipesScreen() {
    RecipesView()
}

@Preview(showSystemUi = true)
@Composable
fun RecipesView() {
    Column(
        modifier = Modifier
            .padding(Dimens.space_x1)
    ) {
        LazyColumn {
            items(getMockedCategoryList()) { recipeCategory ->
                Spacer(modifier = Modifier.height(Dimens.space_half))
                RecipeCategory(
                    recipeCategory.id,
                    recipeCategory.imageId,
                    recipeCategory.title,
                    recipeCategory.description
                ) {
                    // TODO: 16.10.2021 Navigate to category with id
                }
                Spacer(modifier = Modifier.height(Dimens.space_x1))
            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipeCategory() {
    RecipeCategory(
        categoryId = 0,
        imageId = R.drawable.breakfast,
        label = "Breakfast",
        description = "Just a description",
        onClick = {}
    )
}

@Composable
fun RecipeCategory(
    categoryId: Int,
    @DrawableRes imageId: Int,
    label: String,
    description: String,
    onClick: (categoryId: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(Dimens.space_quarter)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            onClick = { onClick(categoryId) }
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
