package com.example.presentation.ui.productDetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun StockBadge(stateProvider: () -> Boolean) {
    val inStock = stateProvider.read { this }
    val contentColor = if (inStock) Color(0xFF32D583) else Color(0xFFFF0000)
    val badgeLabel = if (inStock) "In Stock" else "Out Of Stock"

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(100.dp),
                width = 1.dp
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(contentColor)
        )
        Text(
            text = badgeLabel,
            style = TextStyle(
                color = contentColor,
                fontFamily = DMSansFontFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun InStockBadgePreview() {
    ShoppingAppTheme {
        StockBadge(stateProvider = { true })
    }
}

@PreviewLightDark
@Composable
private fun OutOfStockBadgePreview() {
    ShoppingAppTheme {
        StockBadge(stateProvider = { false })
    }
}