package com.example.presentation.ui.cart.mvi

import com.example.domain.model.CartItem

data class CartScreenState(
    val cartItems: List<CartItem> = emptyList(),
    val shippingCost: Double = 5.0,
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    val totalItemCount: Int
        get() = cartItems.sumOf { cartItem -> cartItem.quantity }

    val subtotal: Double
        get() = cartItems.sumOf { cartItem -> cartItem.totalPrice }

    val total: Double
        get() = subtotal + shippingCost
}