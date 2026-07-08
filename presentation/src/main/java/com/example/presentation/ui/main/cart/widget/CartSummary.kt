package com.example.presentation.ui.main.cart.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

internal data class CartSummaryState(
    val subtotal: Double,
    val shippingCost: Double,
    val total: Double,
    val canProceedToCheckout: Boolean
)

@Composable
internal fun CartSummary(
    modifier: Modifier = Modifier,
    stateProvider: () -> CartSummaryState,
    onProceedToCheckoutClick: () -> Unit
) {
    val subtotal = stateProvider.read { subtotal }
    val shippingCost = stateProvider.read { shippingCost }
    val total = stateProvider.read { total }
    val canProceedToCheckout = stateProvider.read { canProceedToCheckout }

    Column(
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Subtotal",
                    style = TextStyle(
                        color = Color(0xFF6B6B70),
                        fontFamily = DMSansFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start
                    )
                )
                Text(
                    text = "$${"%.2f".format(subtotal)}",
                    style = TextStyle(
                        color = Color(0xFFFAFAF9),
                        fontFamily = DMSansFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shipping",
                    style = TextStyle(
                        color = Color(0xFF6B6B70),
                        fontFamily = DMSansFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start
                    )
                )
                Text(
                    text = "$${"%.2f".format(shippingCost)}",
                    style = TextStyle(
                        color = Color(0xFFFAFAF9),
                        fontFamily = DMSansFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                )
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF2A2A2E)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total",
                    style = TextStyle(
                        color = Color(0xFFFAFAF9),
                        fontFamily = DMSansFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
                Text(
                    text = "$${"%.2f".format(total)}",
                    style = TextStyle(
                        color = Color(0xFF32D583),
                        fontFamily = DMSansFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
            }
        }
        PrimaryButton(
            command = "Proceed to Checkout",
            enabled = canProceedToCheckout,
            onClick = onProceedToCheckoutClick
        )
    }
}

@PreviewLightDark
@Composable
private fun CartSummaryPreview() {
    val cartSummaryState = CartSummaryState(
        subtotal = 0.0,
        shippingCost = 5.0,
        total = 0.0,
        canProceedToCheckout = false
    )

    ShoppingAppTheme {
        CartSummary(
            stateProvider = { cartSummaryState },
            onProceedToCheckoutClick = {}
        )
    }
}