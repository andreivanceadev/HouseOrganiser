package com.andreivanceadev.recipes.list

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.andreivanceadev.common.theme.Dimens
import com.andreivanceadev.recipes.R
import com.andreivanceadev.recipes.list.viewmodel.RecipesListViewModel
import com.andreivanceadev.recipes.list.viewmodel.RecipesListViewState
import com.andreivanceadev.recipes.model.RecipeInfo

@Preview(showSystemUi = true)
@Composable
fun PreviewRecipesListScreen() {
    RecipesListScreen()
}

@Composable
fun RecipesListScreen(
    viewModel: RecipesListViewModel = hiltViewModel()
) {

    val viewState = viewModel.container.stateFlow.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SearchBar()
        RecipesListView(viewState.value)
    }
}

@Composable
fun SearchBar() {

    // TODO: 17.10.2021 val query = viewModel.query.value
    val query = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                value = query.value,
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = { newValue ->
                    query.value = newValue
                },
                label = {
                    Text(text = "Search")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        // TODO: 17.10.2021 viewModel.search(query)
                    }
                ),
                leadingIcon = {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.Search),
                        contentDescription = ""
                    )
                },
                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            )
        }
    }
}

@Composable
fun RecipesListView(viewState: RecipesListViewState) {
    Spacer(modifier = Modifier.height(Dimens.space_x1))
    LazyColumn {
        items(viewState.recipesList) { recipe ->
            RecipeListItem(recipeInfo = recipe)
            Spacer(modifier = Modifier.height(Dimens.space_x1))
        }
    }
}

@Composable
fun RecipeListItem(recipeInfo: RecipeInfo) {

    Card(
        modifier = Modifier
            .width(344.dp)
            .padding(bottom = Dimens.space_x1),
        shape = RoundedCornerShape(Dimens.space_x1)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .height(194.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                painter = if (recipeInfo.imageUrl.isNotEmpty())
                    rememberImagePainter(recipeInfo.imageUrl) else
                // TODO: 17.10.2021 replace with image placeholder for recipes
                    painterResource(id = R.drawable.breakfast),
                contentDescription = "RecipeImage"
            )
            RecipeContent(
                modifier = Modifier.padding(
                    start = Dimens.space_x2,
                    end = Dimens.space_x2,
                    top = Dimens.space_x2
                ),
                recipeInfo = recipeInfo
            )
        }
    }
}

@Composable
fun RecipeContent(modifier: Modifier = Modifier, recipeInfo: RecipeInfo) {
    Column(modifier = modifier) {
        Text(
            text = recipeInfo.title,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(Dimens.space_x2))
        Text(
            text = recipeInfo.type.categoryName,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(Dimens.space_x2))
        Text(
            text = recipeInfo.description,
            style = MaterialTheme.typography.body2
        )
    }
}
