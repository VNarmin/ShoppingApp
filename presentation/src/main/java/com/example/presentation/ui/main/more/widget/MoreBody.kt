package com.example.presentation.ui.main.more.widget

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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class MoreBodyState(
    val username: String,
    val categoryStates: ImmutableList<CategoryState>
)

@Composable
internal fun MoreBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> MoreBodyState,
    onCategoryClick: (String) -> Unit
) {
    val username = stateProvider.read { username }
    val categoryStates = stateProvider.read { categoryStates }

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 4.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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

        items(categoryStates, key = { categoryState -> categoryState.categoryID }) { categoryState ->
            CategoryCard(
                stateProvider = { categoryState },
                onClick = { onCategoryClick(categoryState.categoryID) },
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun MoreBodyPreview() {
    val categoryStates = persistentListOf(
        CategoryState(categoryID = "all",         categoryDisplayName = "All",         categoryItemCount = 926),
        CategoryState(categoryID = "shoes",       categoryDisplayName = "Shoes",       categoryItemCount = 128),
        CategoryState(categoryID = "bags",        categoryDisplayName = "Bags",        categoryItemCount = 86),
        CategoryState(categoryID = "watches",     categoryDisplayName = "Watches",     categoryItemCount = 54),
        CategoryState(categoryID = "tech",        categoryDisplayName = "Tech",        categoryItemCount = 210),
        CategoryState(categoryID = "beauty",      categoryDisplayName = "Beauty",      categoryItemCount = 97),
    )

    val moreBodyState = MoreBodyState(
        username = "Olivia Rodrigo",
        categoryStates = categoryStates
    )

    ShoppingAppTheme {
        MoreBody(
            stateProvider = { moreBodyState },
            onCategoryClick = {},
        )
    }
}