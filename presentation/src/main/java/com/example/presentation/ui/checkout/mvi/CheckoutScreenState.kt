package com.example.presentation.ui.checkout.mvi

import com.example.domain.model.Order

data class CheckoutScreenState(
    val username: String = "Olivia Rodrigo",
    val order : Order,
    val loading: Boolean = false,
    val errorMessage: String? = null
)