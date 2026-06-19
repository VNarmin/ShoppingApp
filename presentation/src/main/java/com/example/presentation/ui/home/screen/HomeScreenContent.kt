package com.example.presentation.ui.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
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
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.base.read
import com.example.presentation.ui.common.BottomNavBar
import com.example.presentation.ui.common.ProductCard
import com.example.presentation.ui.home.mvi.HomeScreenState
import com.example.presentation.ui.home.widget.Banner
import com.example.presentation.ui.home.widget.CategoryFilter
import com.example.presentation.ui.home.widget.HomeHeader
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun HomeScreenContent(
    stateReader : () -> HomeScreenState,
    onSearchQueryChange: (String) -> Unit,
    onCartClick: () -> Unit,
    onCategoryChange: (String) -> Unit,
    onProductClick: (String) -> Unit,
    onMoreClick: () -> Unit
) {
    val username = stateReader.read { username }
    val searchQuery = stateReader.read { searchQuery }
    val categories = stateReader.read { categories }
    val selectedCategoryID = stateReader.read { selectedCategory.categoryID }
    val products = stateReader.read { products }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        bottomBar = {
            BottomNavBar(
                more = false,
                onSwitchTab = onMoreClick
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeHeader(
                    username = username,
                    onCartClick = onCartClick,
                    searchQuery = searchQuery,
                    onSearchQueryChange = onSearchQueryChange
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Banner()
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                CategoryFilter(
                    categories = categories,
                    selectedCategoryID = selectedCategoryID,
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
            items(products) { product ->
                ProductCard(
                    productName = product.name,
                    productPrice = product.price,
                    images = product.images,
                    onClick = { onProductClick(product.productID) }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenContentPreview() {
    val categories = listOf(
        Category(categoryID = "all",         displayName = "All",         itemCount = 926),
        Category(categoryID = "shoes",       displayName = "Shoes",       itemCount = 128),
        Category(categoryID = "bags",        displayName = "Bags",        itemCount = 86),
        Category(categoryID = "watches",     displayName = "Watches",     itemCount = 54),
        Category(categoryID = "tech",        displayName = "Tech",        itemCount = 210),
    )

    val products = listOf(
        Product(
            productID = "shoes_1",
            name = "Nike Air Max 270",
            description = "The Nike Air Max 270 was designed to keep you moving from morning to night without sacrificing style. A breathable mesh upper wraps your foot in lightweight support, while the responsive Air cushioning absorbs every step and gives energy back to your stride. Whether you're commuting, running errands, or just spending long hours on your feet, these shoes deliver the kind of all-day comfort that makes you forget you're even wearing them.",
            price = 129.00,
            images = listOf("#6366F1", "#E85A4F", "#32D583"),
            category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 10,
            rating = 4.8,
            reviewCount = 128
        ),
        Product(
            productID = "shoes_2",
            name = "Retro Runner",
            description = "The Retro Runner takes everything you loved about classic running shoes and rebuilds it for today's streets. A vintage-inspired sole unit has been updated with modern cushioning technology so you get the look of the past without sacrificing the comfort of the present. The clean silhouette pairs easily with casual outfits, making it a shoe you'll find yourself reaching for day after day.",
            price = 99.00,
            images = listOf("#E85A4F", "#6366F1", "#32D583"),
            category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 5,
            rating = 4.5,
            reviewCount = 86
        ),
        Product(
            productID = "shoes_3",
            name = "Sport Sandal",
            description = "The Sport Sandal was built for people who refuse to slow down, even in warm weather. Fully adjustable straps let you dial in a secure fit whether you're hiking a trail or walking through town, and the contoured footbed supports your arch through long days on your feet. A grippy rubber outsole bites into both wet and dry surfaces, so you can move with confidence no matter where the day takes you.",
            price = 74.00,
            images = listOf("#32D583", "#6366F1", "#E85A4F"),
            category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 8,
            rating = 4.3,
            reviewCount = 54
        ),
        Product(
            productID = "shoes_4",
            name = "Classic Sneaker",
            description = "Some shoes try to do too much, but the Classic Sneaker knows exactly what it is. A premium leather upper ages beautifully over time, developing character the more you wear it, while a cushioned insole keeps your feet comfortable through whatever the day demands. The low-top silhouette works just as well with jeans and a jacket as it does with shorts and a t-shirt, making it one of the most versatile shoes you'll ever own.",
            price = 110.00,
            images = listOf("#FFB547", "#6366F1", "#E85A4F"),
            category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 12,
            rating = 4.6,
            reviewCount = 210
        )
    )

    val selectedCategory = Category(
        categoryID = "all",
        displayName = "All",
        itemCount = 926
    )

    val homeScreenState = HomeScreenState(
        categories = categories,
        products = products,
        selectedCategory = selectedCategory,
    )

    ShoppingAppTheme {
        HomeScreenContent(
            stateReader = { homeScreenState },
            onSearchQueryChange = {},
            onCartClick = {},
            onCategoryChange = {},
            onProductClick = {},
            onMoreClick = {}
        )
    }
}