package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import androidx.core.graphics.toColorInt
import com.example.presentation.base.read

internal data class ProductCardState(
    val productName: String,
    val productPrice: Double,
    val productImages: List<String>
)

@Composable
internal fun ProductCard(
    stateProvider: () -> ProductCardState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val productName = stateProvider.read { productName }
    val productPrice = stateProvider.read { productPrice }
    val productImages = stateProvider.read { productImages }

    val backgroundColor = remember(productImages) {
        runCatching { Color(productImages.firstOrNull().orEmpty().toColorInt()) }
            .getOrDefault(Color.Gray)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(16.dp),
                width = 1.dp
            )
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(124F / 168F)
                .background(backgroundColor)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = productName,
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = "$${"%.2f".format(productPrice)}",
                style = TextStyle(
                    color = Color(0xFF32D583),
                    fontFamily = DMSansFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Product1CardPreview() {
    val productCartState = ProductCardState(
        productName = "Nike Air Max",
        productPrice = 129.00,
        productImages = listOf("#6366F1", "#E85A4F", "#32D583"),
    )
    ShoppingAppTheme {
        ProductCard(
            stateProvider = { productCartState },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun Product2CardPreview() {
    val productCardState = ProductCardState(
        productName = "Retro Runner",
        productPrice = 99.00,
        productImages = listOf("#E85A4F", "#6366F1", "#32D583"),
    )
    ShoppingAppTheme {
        ProductCard(
            stateProvider = { productCardState },
            onClick = {}
        )
    }
}