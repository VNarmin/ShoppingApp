package com.example.presentation.ui.orderConfirmation.mvi

data class OrderConfirmationScreenState(
    val orderID: String = "",
    val loading: Boolean = false,
    val errorMessage: String? = null
)