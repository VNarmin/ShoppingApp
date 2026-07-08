package com.example.presentation.ui.main.cart.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.base.focusOn
import com.example.presentation.base.read
import com.example.presentation.ui.common.QuantitySelectorState
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class CartBodyState(
    val cartItemStates: ImmutableList<CartItemState>,
    val cartSummaryState: CartSummaryState
)

@Composable
internal fun CartBody(
    modifier: Modifier = Modifier,
    stateProvider: () -> CartBodyState,
    onDeleteClick: (String) -> Unit,
    onAddClick: (String) -> Unit,
    onRemoveClick: (String) -> Unit,
    onProceedToCheckOutClick: () -> Unit
) {
    val cartItemStates = stateProvider.read { cartItemStates }
    val cartSummaryStateProvider = stateProvider.focusOn { cartSummaryState }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(horizontal = 20.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(cartItemStates, key = { cartItemState -> cartItemState.productID }) { cartItemState ->
                CartItemCard(
                    stateProvider = { cartItemState },
                    onDelete = { onDeleteClick(cartItemState.productID) },
                    onAdd = { onAddClick(cartItemState.productID) },
                    onRemove = { onRemoveClick(cartItemState.productID) },
                )
            }
        }
        CartSummary(
            stateProvider = cartSummaryStateProvider,
            onProceedToCheckoutClick = onProceedToCheckOutClick
        )
    }
}

@PreviewLightDark
@Composable
private fun CartBodyPreview() {
    val cartItemStates = persistentListOf(
        CartItemState(
            productID = "shoes_01",
            productName = "Nike Air Max 270",
            productPrice = 129.00,
            productImages = listOf("#6366F1", "#E85A4F", "#32D583"),
            quantitySelectorState = QuantitySelectorState(
                quantity = 1,
                stockCount = 10
            )
        ),
        CartItemState(
            productID = "shoes_02",
            productName = "Retro Runners",
            productPrice = 99.00,
            productImages = listOf("#E85A4F", "#6366F1", "#32D583"),
            quantitySelectorState = QuantitySelectorState(
                quantity = 2,
                stockCount = 5
            )
        ),
        CartItemState(
            productID = "shoes_03",
            productName = "Nike Air Max 270",
            productPrice = 74.00,
            productImages = listOf("#32D583", "#6366F1", "#E85A4F"),
            quantitySelectorState = QuantitySelectorState(
                quantity = 3,
                stockCount = 8
            )
        )
    )

    val cartSummaryState = CartSummaryState(
        subtotal = 549.0,
        shippingCost = 5.0,
        total = 554.0,
        canProceedToCheckout = true
    )

    val cartBodyState = CartBodyState(
        cartItemStates = cartItemStates,
        cartSummaryState = cartSummaryState
    )

    ShoppingAppTheme {
        CartBody(
            stateProvider = { cartBodyState },
            onDeleteClick = {},
            onAddClick = {},
            onRemoveClick = {},
            onProceedToCheckOutClick = {}
        )
    }
}