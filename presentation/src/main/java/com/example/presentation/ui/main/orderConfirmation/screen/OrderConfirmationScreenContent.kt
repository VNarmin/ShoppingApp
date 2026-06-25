package com.example.presentation.ui.main.orderConfirmation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.presentation.ui.main.orderConfirmation.widget.OrderConfirmationBody
import com.example.presentation.ui.main.orderConfirmation.widget.OrderConfirmationFooter
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun OrderConfirmationScreenContent(
    onContinueShoppingClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OrderConfirmationBody(modifier = Modifier.weight(1F))
        OrderConfirmationFooter(onContinueShoppingClick = onContinueShoppingClick)
    }
}

@PreviewLightDark
@Composable
private fun OrderConfirmationScreenContentPreview() {
    ShoppingAppTheme {
        OrderConfirmationScreenContent(onContinueShoppingClick = {})
    }
}