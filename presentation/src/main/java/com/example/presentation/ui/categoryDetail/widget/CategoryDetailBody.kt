package com.example.presentation.ui.categoryDetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.presentation.ui.categoryDetail.mvi.CategoryDetailScreenState
import com.example.presentation.ui.common.ProductCard
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun CategoryDetailBody(
    stateProvider: () -> CategoryDetailScreenState,
    modifier: Modifier = Modifier,
    onProductClick : (String) -> Unit
) {
    val itemCount = stateProvider.read { currentCategory.itemCount }
    val products = stateProvider.read { products }

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$itemCount results",
                    style = TextStyle(
                        color = Color(0xFF6B6B70),
                        fontFamily = DMSansFontFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start
                    )
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0xFF16161A))
                        .border(
                            color = Color(0xFF2A2A2E),
                            shape = RoundedCornerShape(100.dp),
                            width = 1.dp
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.SwapVert,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFFFAFAF9)
                    )
                    Text(
                        text = "Popular",
                        style = TextStyle(
                            color = Color(0xFFFAFAF9),
                            fontFamily = DMSansFontFamily,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Start
                        )
                    )
                }
            }
        }

        items(products) { product ->
            ProductCard(
                productName = product.name,
                productPrice = product.price,
                images = product.images,
                onClick = { onProductClick(product.productID) },
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun CategoryDetailBodyPreview() {
    val currentCategory = Category(
        categoryID = "shoes",
        displayName = "Shoes",
        itemCount = 128
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

    val categoryDetailScreenState = CategoryDetailScreenState(
        currentCategory = currentCategory,
        products = products
    )

    ShoppingAppTheme {
        CategoryDetailBody(
            stateProvider = { categoryDetailScreenState },
            onProductClick = {},
        )
    }
}