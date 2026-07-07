package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

internal data class QuantitySelectorState(
    val quantity: Int,
    val stockCount: Int
)

@Composable
internal fun QuantitySelector(
    modifier: Modifier = Modifier,
    stateProvider: () -> QuantitySelectorState,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    val quantity = stateProvider.read { quantity }
    val stockCount = stateProvider.read { stockCount }

    val canAdd = stockCount > 0 && quantity < stockCount
    val canRemove = stockCount > 0 && quantity > 1

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(12.dp),
                width = 1.dp
            )
            .padding(4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuantityActionButton(
            enabled = canRemove,
            icon = Icons.Default.Remove,
            onClick = onRemove
        )
        Text(
            modifier = Modifier.width(40.dp),
            text = if (stockCount > 0) quantity.toString() else "0",
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        QuantityActionButton(
            enabled = canAdd,
            icon = Icons.Default.Add,
            onClick = onAdd
        )
    }
}

@Composable
private fun QuantityActionButton(
    enabled: Boolean,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (enabled) Color(0xFF6366F1) else Color(0xFF1A1A1E))
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color(0xFFFFFFFF)
        )
    }
}

@PreviewLightDark
@Composable
private fun QuantitySelectorCase1Preview() {
    val quantitySelectorState = QuantitySelectorState(
        quantity = 1,
        stockCount = 36
    )

    ShoppingAppTheme {
        QuantitySelector(
            stateProvider = { quantitySelectorState },
            onAdd = {},
            onRemove = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun QuantitySelectorCase2Preview() {
    val quantitySelectorState = QuantitySelectorState(
        quantity = 5,
        stockCount = 36
    )

    ShoppingAppTheme {
        QuantitySelector(
            stateProvider = { quantitySelectorState },
            onAdd = {},
            onRemove = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun QuantitySelectorCase3Preview() {
    val quantitySelectorState = QuantitySelectorState(
        quantity = 0,
        stockCount = 0
    )

    ShoppingAppTheme {
        QuantitySelector(
            stateProvider = { quantitySelectorState },
            onAdd = {},
            onRemove = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun QuantitySelectorCase4Preview() {
    val quantitySelectorState = QuantitySelectorState(
        quantity = 36,
        stockCount = 36
    )

    ShoppingAppTheme {
        QuantitySelector(
            stateProvider = { quantitySelectorState },
            onAdd = {},
            onRemove = {}
        )
    }
}