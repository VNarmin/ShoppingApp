package com.example.presentation.ui.main.cart.mvi

import androidx.compose.runtime.Immutable
import com.example.domain.model.CartItem
import com.example.presentation.ui.common.QuantitySelectorState
import com.example.presentation.ui.main.cart.widget.CartBodyState
import com.example.presentation.ui.main.cart.widget.CartItemState
import com.example.presentation.ui.main.cart.widget.CartSummaryState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class CartScreenState(
    val cartItems: ImmutableList<CartItem> = persistentListOf(),
    val loading: Boolean = false,
    val errorMessage: String? = null,
) {
    val totalItemCount: Int
        get() = cartItems.sumOf { cartItem -> cartItem.quantity }

    private fun formCartItemStates(): ImmutableList<CartItemState> =
        cartItems.map { cartItem ->
            CartItemState(
                productID = cartItem.product.productID,
                productName = cartItem.product.name,
                productPrice = cartItem.product.price,
                productImages = cartItem.product.images,
                quantitySelectorState = QuantitySelectorState(
                    quantity = cartItem.quantity,
                    stockCount = cartItem.product.stockCount,
                ),
            )
        }.toImmutableList()

    private fun formCartSummaryState(): CartSummaryState {
        val subtotal = cartItems.sumOf { cartItem -> cartItem.totalPrice }
        val shippingCost = if (cartItems.isEmpty()) 0.0 else SHIPPING_COST
        return CartSummaryState(
            subtotal = subtotal,
            shippingCost = shippingCost,
            total = subtotal + shippingCost,
            canProceedToCheckout = cartItems.isNotEmpty(),
        )
    }

    fun formCartBodyState(): CartBodyState = CartBodyState(
        cartItemStates = formCartItemStates(),
        cartSummaryState = formCartSummaryState(),
    )

    companion object {
        private const val SHIPPING_COST = 5.0
        val INITIAL = CartScreenState()
    }
}