package com.example.presentation.ui.productDetail.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.ui.common.IconButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun ProductDetailHeader(
    onBackClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = onBackClick
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                icon = Icons.Default.FavoriteBorder,
                onClick = {}
            )
            IconButton(
                icon = Icons.Default.ShoppingCart,
                onClick = onCartClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun ProductDetailHeaderPreview() {
    ShoppingAppTheme {
        ProductDetailHeader(
            onBackClick = {},
            onCartClick = {}
        )
    }
}