package com.example.presentation.ui.checkout.mvi

import com.example.domain.model.Order
import com.example.presentation.ui.checkout.widget.OrderSummaryState

internal data class CheckoutScreenState(
    val username: String = "",
    val order: Order = Order(
        orderID = "",
        cartItems = emptyList(),
        shippingCost = 0.0
    ),
    val orderSummaryState: OrderSummaryState = OrderSummaryState(
        totalItemCount = 0,
        subtotal = 0.0,
        shippingCost = 5.0,
        total = 0.0
    ),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = CheckoutScreenState()
    }
}