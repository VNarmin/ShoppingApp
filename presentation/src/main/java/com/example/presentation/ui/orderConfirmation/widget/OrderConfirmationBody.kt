package com.example.presentation.ui.orderConfirmation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Brush
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
import com.example.presentation.ui.orderConfirmation.mvi.OrderConfirmationScreenState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun OrderConfirmationBody(
    stateProvider: () -> OrderConfirmationScreenState,
    modifier: Modifier = Modifier
) {
    val orderID = stateProvider.read { orderID }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF32D583), Color(0xFF059669))
                    )
                )
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        radius = 24.dp,
                        spread = 2.dp,
                        color = Color(0xFF32D583).copy(alpha = 0.20F),
                        offset = DpOffset(0.dp, 8.dp)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFF0B0B0E)
            )
        }
        Text(
            text = "Order Confirmed!",
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = "Thanks for your purchase! Your order is being prepared and will be on its way soon.",
            style = TextStyle(
                color = Color(0xFF6B6B70),
                fontFamily = DMSansFontFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF16161A))
                .border(
                    color = Color(0xFF2A2A2E),
                    shape = RoundedCornerShape(12.dp),
                    width = 1.dp
                )
                .padding(horizontal = 18.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Order No.",
                style = TextStyle(
                    color = Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = orderID,
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
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
private fun OrderConfirmationBodyPreview() {
    val orderID = "SHP-2026-8756"
    val orderConfirmationScreenState = OrderConfirmationScreenState(orderID = orderID)

    ShoppingAppTheme {
        OrderConfirmationBody(stateProvider = { orderConfirmationScreenState })
    }
}