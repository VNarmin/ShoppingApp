package com.example.presentation.ui.main.categoryDetail.widget

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
import com.example.presentation.base.read
import com.example.presentation.ui.common.ProductCard
import com.example.presentation.ui.common.ProductCardState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class CategoryDetailBodyState(
    val itemCount: Int,
    val productStates: ImmutableList<ProductCardState>
)

@Composable
internal fun CategoryDetailBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> CategoryDetailBodyState,
    onProductClick: (String) -> Unit
) {
    val itemCount = stateProvider.read { itemCount }
    val productStates = stateProvider.read { productStates }

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
private fun CategoryDetailBodyPreview() {
    val productStates = persistentListOf(
        ProductCardState(
            productID = "shoes_1",
            productName = "Nike Air Max 270",
            productPrice = 129.00,
            productImages = listOf("#6366F1", "#E85A4F", "#32D583")
        ),
        ProductCardState(
            productID = "shoes_2",
            productName = "Retro Runner",
            productPrice = 99.00,
            productImages = listOf("#E85A4F", "#6366F1", "#32D583")
        ),
        ProductCardState(
            productID = "shoes_3",
            productName = "Sport Sandal",
            productPrice = 74.00,
            productImages = listOf("#32D583", "#6366F1", "#E85A4F")
        ),
        ProductCardState(
            productID = "shoes_4",
            productName = "Classic Sneaker",
            productPrice = 110.00,
            productImages = listOf("#FFB547", "#6366F1", "#E85A4F")
        )
    )

    val categoryDetailBodyState = CategoryDetailBodyState(
        itemCount = 128,
        productStates = productStates
    )

    ShoppingAppTheme {
        CategoryDetailBody(
            stateProvider = { categoryDetailBodyState },
            onProductClick = {},
        )
    }
}