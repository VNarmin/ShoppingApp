package com.example.presentation.ui.main.productDetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun ProductDetailFooter(
    modifier: Modifier = Modifier,
    stateProvider: () -> Boolean,
    onAddToCartClick: () -> Unit,
    onBuyNowClick: () -> Unit
) {
    val canPurchase = stateProvider.read { this }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF0B0B0E))
            .drawBehind {
                drawLine(
                    color = Color(0xFF2A2A2E),
                    start = Offset(0F, 0F),
                    end = Offset(size.width, 0F),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .weight(1F)
                .then(
                    if (canPurchase) {
                        Modifier.dropShadow(
                            shape = RoundedCornerShape(14.dp),
                            shadow = Shadow(
                                radius = 24.dp,
                                spread = 2.dp,
                                color = Color(0xFF6366F1).copy(alpha = 0.20F),
                                offset = DpOffset(0.dp, 8.dp)
                            )
                        )
                    } else {
                        Modifier.border(
                            color = Color(0xFF3A3A40),
                            shape = RoundedCornerShape(14.dp),
                            width = 1.dp
                        )
                    }
                )
                .clip(RoundedCornerShape(14.dp))
                .background(if (canPurchase) Color(0xFF6366F1) else Color(0xFF1A1A1E))
                .clickable(enabled = canPurchase, onClick = onAddToCartClick)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                modifier = Modifier.size(20.dp),
                contentDescription = null,
                tint = Color(0xFFFAFAF9)
            )
            Text(
                text = "Add to Cart",
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
        }

        PrimaryButton(
            modifier = Modifier.weight(1F),
            command = "Buy Now",
            enabled = canPurchase,
            onClick = onBuyNowClick
        )
    }
}

@PreviewLightDark
@Composable
private fun ProductDetailFooterEnabledPreview() {
    ShoppingAppTheme {
        ProductDetailFooter(
            stateProvider = { true },
            onAddToCartClick = {},
            onBuyNowClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun ProductDetailFooterDisabledPreview() {
    ShoppingAppTheme {
        ProductDetailFooter(
            stateProvider = { false },
            onAddToCartClick = {},
            onBuyNowClick = {}
        )
    }
}