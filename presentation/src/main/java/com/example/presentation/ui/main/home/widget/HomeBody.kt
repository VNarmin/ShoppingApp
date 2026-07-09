package com.example.presentation.ui.main.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import com.example.presentation.base.focusOn
import com.example.presentation.base.read
import com.example.presentation.ui.common.InputField
import com.example.presentation.ui.common.ProductCard
import com.example.presentation.ui.common.ProductState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class HomeBodyState(
    val searchQuery: String,
    val categoryFilterState: CategoryFilterState,
    val productStates: ImmutableList<ProductState>
)

@Composable
internal fun HomeBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> HomeBodyState,
    onSearchQueryChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onProductClick: (String) -> Unit,
) {
    val searchQuery = stateProvider.read { searchQuery }
    val categoryFilterStateProvider = stateProvider.focusOn { categoryFilterState }
    val productStates = stateProvider.read { productStates }

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            InputField(
                placeholder = "Search products...",
                leadingIcon = Icons.Filled.Search,
                password = false,
                value = searchQuery,
                onValueChange = onSearchQueryChange
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Banner()
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            CategoryFilter(
                stateProvider = categoryFilterStateProvider,
                onCategoryChange = onCategoryChange
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "Popular Now",
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
        }
        items(productStates, key = { productState -> productState.productID }) { productState ->
            ProductCard(
                stateProvider = { productState },
                onClick = { onProductClick(productState.productID) }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeBodyPreview() {
    val categoryStates = persistentListOf(
        CategoryState(categoryID = "all",         categoryLabel = "All",         categorySelected = true),
        CategoryState(categoryID = "shoes",       categoryLabel = "Shoes",       categorySelected = false),
        CategoryState(categoryID = "bags",        categoryLabel = "Bags",        categorySelected = false),
        CategoryState(categoryID = "watches",     categoryLabel = "Watches",     categorySelected = false),
        CategoryState(categoryID = "tech",        categoryLabel = "Tech",        categorySelected = false)
    )

    val productStates = persistentListOf(
        ProductState(
            productID = "shoes_1",
            productName = "Nike Air Max 270",
            productPrice = 129.00,
            productImages = persistentListOf("#6366F1", "#E85A4F", "#32D583")
        ),
        ProductState(
            productID = "shoes_2",
            productName = "Retro Runner",
            productPrice = 99.00,
            productImages = persistentListOf("#E85A4F", "#6366F1", "#32D583")
        ),
        ProductState(
            productID = "shoes_3",
            productName = "Sport Sandal",
            productPrice = 74.00,
            productImages = persistentListOf("#32D583", "#6366F1", "#E85A4F")
        ),
        ProductState(
            productID = "shoes_4",
            productName = "Classic Sneaker",
            productPrice = 110.00,
            productImages = persistentListOf("#FFB547", "#6366F1", "#E85A4F")
        )
    )

    val homeBodyState = HomeBodyState(
        searchQuery = "",
        categoryFilterState = CategoryFilterState(
            categoryStates = categoryStates
        ),
        productStates = productStates,
    )

    ShoppingAppTheme {
        HomeBody(
            stateProvider = { homeBodyState },
            onSearchQueryChange = {},
            onCategoryChange = {},
            onProductClick = {}
        )
    }
}