package com.example.presentation.ui.main.checkout.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.presentation.ui.main.checkout.mvi.CheckoutScreenState
import com.example.presentation.ui.main.checkout.widget.CheckoutBody
import com.example.presentation.ui.main.checkout.widget.CheckoutHeader
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun CheckoutScreenContent(
    stateProvider: () -> CheckoutScreenState,
    onBackClick: () -> Unit,
    onPlaceOrderClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            CheckoutHeader(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        CheckoutBody(
            stateProvider = stateProvider,
            onPlaceOrderClick = onPlaceOrderClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@PreviewLightDark
@Composable
private fun CheckoutScreenContentPreview() {
    val checkoutScreenState = CheckoutScreenState()

    ShoppingAppTheme {
        CheckoutScreenContent(
            stateProvider = { checkoutScreenState },
            onBackClick = {},
            onPlaceOrderClick = {}
        )
    }
}