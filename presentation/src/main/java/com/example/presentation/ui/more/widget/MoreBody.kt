package com.example.presentation.ui.more.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Category
import com.example.presentation.base.read
import com.example.presentation.ui.more.mvi.MoreScreenState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun MoreBody(
    stateReader: () -> MoreScreenState,
    onCategoryClick : (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val username = stateReader.read { username }
    val categories = stateReader.read { categories }

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 4.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "More",
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            ProfileSettingsCard(username = username)
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "Shop by Category",
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
        }

        items(categories) { category ->
            CategoryCard(
                categoryDisplayName = category.displayName,
                categoryItemCount = category.itemCount,
                onClick = { onCategoryClick(category.categoryID) },
            )
        }
    }
}

@Preview
@Composable
private fun MoreBodyPreview() {
    val categories = listOf(
        Category(categoryID = "all",         displayName = "All",         itemCount = 926),
        Category(categoryID = "shoes",       displayName = "Shoes",       itemCount = 128),
        Category(categoryID = "bags",        displayName = "Bags",        itemCount = 86),
        Category(categoryID = "watches",     displayName = "Watches",     itemCount = 54),
        Category(categoryID = "tech",        displayName = "Tech",        itemCount = 210),
        Category(categoryID = "beauty",      displayName = "Beauty",      itemCount = 97),
    )

    val moreScreenState = MoreScreenState(
        username = "Olivia Rodrigo",
        categories = categories,
    )

    ShoppingAppTheme {
        MoreBody(
            stateReader = { moreScreenState },
            onCategoryClick = {},
        )
    }
}