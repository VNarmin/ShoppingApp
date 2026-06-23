package com.example.presentation.ui.orderConfirmation.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun OrderConfirmationFooter(
    modifier: Modifier = Modifier,
    onContinueShoppingClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PrimaryButton(
            command = "Continue Shopping",
            enabled = true,
            onClick = onContinueShoppingClick
        )
        PrimaryButton(
            command = "View Order",
            enabled = false,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun OrderConfirmationFooterPreview() {
    ShoppingAppTheme {
        OrderConfirmationFooter(onContinueShoppingClick = {})
    }
}