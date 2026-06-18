package com.example.domain.model

data class Order(
    val orderID: String,
    val cartItems: List<CartItem>,
    val shippingCost: Double
) {
    val totalItemCount: Int
        get() = cartItems.sumOf { cartItem -> cartItem.quantity }

    val subtotal: Double
        get() = cartItems.sumOf { cartItem -> cartItem.totalPrice }

    val total: Double
        get() = subtotal + shippingCost
}