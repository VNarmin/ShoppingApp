package com.example.presentation.ui.orderConfirmation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.presentation.ui.orderConfirmation.mvi.OrderConfirmationScreenState
import com.example.presentation.ui.orderConfirmation.widget.OrderConfirmationBody
import com.example.presentation.ui.orderConfirmation.widget.OrderConfirmationFooter
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun OrderConfirmationScreenContent(
    stateProvider: () -> OrderConfirmationScreenState,
    onContinueShoppingClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OrderConfirmationBody(
            stateProvider = stateProvider,
            modifier = Modifier.weight(1F)
        )
        OrderConfirmationFooter(onContinueShoppingClick = onContinueShoppingClick)
    }
}

@PreviewLightDark
@Composable
private fun OrderConfirmationScreenContentPreview() {
    val orderID = "SHP-2026-8856"
    val orderConfirmationScreenState = OrderConfirmationScreenState(orderID = orderID)

    ShoppingAppTheme {
        OrderConfirmationScreenContent(
            stateProvider = { orderConfirmationScreenState },
            onContinueShoppingClick = {}
        )
    }
}