package com.example.presentation.ui.cart.mvi

import com.example.domain.model.CartItem
import com.example.presentation.ui.cart.widget.CartSummaryState

internal data class CartScreenState(
    val cartItems: List<CartItem> = emptyList(),
    val totalItemCount: Int = 0,
    val cartSummaryState: CartSummaryState = CartSummaryState(
        subtotal = 0.0,
        shippingCost = 5.0,
        total = 0.0
    ),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = CartScreenState()
    }
}