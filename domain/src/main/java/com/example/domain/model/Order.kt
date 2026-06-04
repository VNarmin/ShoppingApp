package com.example.domain.model

data class Order(
    val orderID: String,
    val items: List<CartItem>,
    val subtotal: Double,
    val shippingCost: Double,
    val totalPrice: Double
)