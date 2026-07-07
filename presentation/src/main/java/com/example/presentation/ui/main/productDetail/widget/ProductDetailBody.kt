package com.example.presentation.ui.main.productDetail.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.base.focusOn
import com.example.presentation.base.read
import com.example.presentation.ui.common.QuantitySelector
import com.example.presentation.ui.common.QuantitySelectorState
import com.example.presentation.ui.main.productDetail.mvi.ProductDetailScreenState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun ProductDetailBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> ProductDetailScreenState,
    onReadMoreClick: () -> Unit,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit
) {
    val product = stateProvider.read { product }
    val descriptionExpanded = stateProvider.read { descriptionExpanded }

    val productImagesProvider = stateProvider.focusOn { product.images }
    val productInStockProvider = stateProvider.focusOn { product.inStock }
    val quantitySelectorStateProvider = stateProvider.focusOn {
        QuantitySelectorState(quantity = quantity, stockCount = product.stockCount)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ProductImagePager(stateProvider = productImagesProvider)

        Text(
            text = product.name,
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$${"%.2f".format(product.price)}",
                style = TextStyle(
                    color = Color(0xFF32D583),
                    fontFamily = DMSansFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
            StockBadge(stateProvider = productInStockProvider)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.StarBorder,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color(0xFFFFB547)
            )
            Text(
                text = "%.1f".format(product.rating),
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = "· ${product.reviewCount} reviews",
                style = TextStyle(
                    color = Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            )
        }

        Text(
            text = product.description,
            maxLines = if (descriptionExpanded) Int.MAX_VALUE else 3,
            overflow = if (descriptionExpanded) TextOverflow.Clip else TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color(0xFF8E8E93),
                fontFamily = DMSansFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )
        )

        Text(
            modifier = Modifier.clickable(onClick = onReadMoreClick),
            text = if (descriptionExpanded) "Read Less" else "Read More",
            style = TextStyle(
                color = Color(0xFF6366F1),
                fontFamily = DMSansFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Quantity",
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
            QuantitySelector(
                stateProvider = quantitySelectorStateProvider,
                onAdd = onAddClick,
                onRemove = onRemoveClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun DetailBodyPreview() {
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
        ProductDetailBody(
            stateProvider = { productDetailScreenState },
            onReadMoreClick = {},
            onAddClick = {},
            onRemoveClick = {}
        )
    }
}