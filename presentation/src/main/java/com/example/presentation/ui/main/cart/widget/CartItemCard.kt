package com.example.presentation.ui.main.cart.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.presentation.base.focusOn
import com.example.presentation.base.read
import com.example.presentation.ui.common.QuantitySelector
import com.example.presentation.ui.common.QuantitySelectorState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class CartItemState(
    val productID: String,
    val productName: String,
    val productPrice: Double,
    val productImages: ImmutableList<String>,
    val quantitySelectorState: QuantitySelectorState
)

@Composable
internal fun CartItemCard(
    modifier: Modifier = Modifier,
    stateProvider: () -> CartItemState,
    onDelete: () -> Unit,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    val productName = stateProvider.read { productName }
    val productPrice = stateProvider.read { productPrice }
    val productImages = stateProvider.read { productImages }
    val quantitySelectorStateProvider = stateProvider.focusOn { quantitySelectorState }

    Row(
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(16.dp),
                width = 1.dp
            )
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(productImages.first().toColorInt()))
        )
        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = productName,
                    style = TextStyle(
                        color = Color(0xFFFAFAF9),
                        fontFamily = DMSansFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                )
                Icon(
                    imageVector = Icons.Default.DeleteOutline,
                    contentDescription = null,
                    tint = Color(0xFF6B6B70),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onDelete)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${"%.2f".format(productPrice)}",
                    style = TextStyle(
                        color = Color(0xFF32D583),
                        fontFamily = DMSansFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
                QuantitySelector(
                    stateProvider = quantitySelectorStateProvider,
                    onAdd = onAdd,
                    onRemove = onRemove
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CartItemCardPreview() {
    val cartItemState = CartItemState(
        productID = "shoes_2",
        productName = "Retro Runner",
        productPrice = 99.00,
        productImages = persistentListOf("#E85A4F", "#6366F1", "#32D583"),
        quantitySelectorState = QuantitySelectorState(
            quantity = 2,
            stockCount = 5
        )
    )

    ShoppingAppTheme {
        CartItemCard(
            stateProvider = { cartItemState },
            onDelete = {},
            onAdd = {},
            onRemove = {}
        )
    }
}