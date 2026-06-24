package com.example.presentation.ui.main.productDetail.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.base.read
import com.example.presentation.ui.main.productDetail.mvi.ProductDetailScreenState
import com.example.presentation.ui.main.productDetail.widget.ProductDetailBody
import com.example.presentation.ui.main.productDetail.widget.ProductDetailFooter
import com.example.presentation.ui.main.productDetail.widget.ProductDetailHeader
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun ProductDetailScreenContent(
    stateProvider: () -> ProductDetailScreenState,
    onBackClick: () -> Unit,
    onCartClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onAddToCartClick: () -> Unit,
    onBuyNowClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            ProductDetailHeader(
                onBackClick = onBackClick,
                onCartClick = onCartClick
            )
        },
        content = { innerPadding ->
            ProductDetailBody(
                stateProvider = stateProvider,
                onReadMoreClick = onReadMoreClick,
                onAddClick = onAddClick,
                onRemoveClick = onRemoveClick,
                modifier = Modifier.padding(innerPadding)
            )
        },
        bottomBar = {
            ProductDetailFooter(
                enabled = stateProvider.read { product.inStock },
                onAddToCartClick = onAddToCartClick,
                onBuyNowClick = onBuyNowClick
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun ProductDetailScreenContentPreview() {
    val sampleProduct = Product(
        productID = "shoes_1",
        name = "Nike Air Max 270",
        description = "The Nike Air Max 270 was designed to keep you moving from morning to night without sacrificing style. A breathable mesh upper wraps your foot in lightweight support, while the responsive Air cushioning absorbs every step and gives energy back to your stride. Whether you're commuting, running errands, or just spending long hours on your feet, these shoes deliver the kind of all-day comfort that makes you forget you're even wearing them.",
        price = 129.00,
        images = listOf("#6366F1", "#E85A4F", "#32D583"),
        category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
        stockCount = 10,
        rating = 4.8,
        reviewCount = 128
    )

    val productDetailScreenState = ProductDetailScreenState(product = sampleProduct)

    ShoppingAppTheme {
        ProductDetailScreenContent(
            stateProvider = { productDetailScreenState },
            onBackClick = {},
            onCartClick = {},
            onReadMoreClick = {},
            onAddClick = {},
            onRemoveClick = {},
            onAddToCartClick = {},
            onBuyNowClick = {}
        )
    }
}