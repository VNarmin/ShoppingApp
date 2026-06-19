package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun IconButton(
    icon : ImageVector,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = CircleShape,
                width = 1.dp
            )
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color(0xFFFAFAF9)
        )
    }
}

@PreviewLightDark
@Composable
private fun BackButtonPreview() {
    ShoppingAppTheme {
        IconButton(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun CartButtonPreview() {
    ShoppingAppTheme {
        IconButton(
            icon = Icons.Default.ShoppingCart,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun LikeButtonPreview() {
    ShoppingAppTheme {
        IconButton(
            icon = Icons.Default.FavoriteBorder,
            onClick = {}
        )
    }
}