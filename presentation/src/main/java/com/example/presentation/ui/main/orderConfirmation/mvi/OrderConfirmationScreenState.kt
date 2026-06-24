package com.example.presentation.ui.main.orderConfirmation.mvi

internal data class OrderConfirmationScreenState(
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = OrderConfirmationScreenState()
    }
}