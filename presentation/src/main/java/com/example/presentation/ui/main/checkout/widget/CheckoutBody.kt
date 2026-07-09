package com.example.presentation.ui.main.checkout.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.base.focusOn
import com.example.presentation.base.read
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

internal data class CheckoutBodyState(
    val username: String,
    val orderSummaryState: OrderSummaryState
)

@Composable
internal fun CheckoutBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> CheckoutBodyState,
    onPlaceOrderClick: () -> Unit
) {
    val username = stateProvider.read { username }
    val total = stateProvider.read { orderSummaryState.total }
    val orderSummaryStateProvider = stateProvider.focusOn { orderSummaryState }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(horizontal = 20.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DeliveryAddressCard(username = username)
            PaymentMethodCard()
            OrderSummary(stateProvider = orderSummaryStateProvider)
        }
        Box(
            modifier = Modifier
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
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(
                command = "Place Order · $${"%.2f".format(total)}",
                enabled = true,
                onClick = onPlaceOrderClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun CheckoutBodyPreview() {
    val checkoutBodyState = CheckoutBodyState(
        username = "Olivia Rodrigo",
        orderSummaryState = OrderSummaryState(
            totalItemCount = 0,
            subtotal = 0.0,
            shippingCost = 0.0,
            total = 0.0
        )
    )

    ShoppingAppTheme {
        CheckoutBody(
            stateProvider = { checkoutBodyState },
            onPlaceOrderClick = {},
        )
    }
}