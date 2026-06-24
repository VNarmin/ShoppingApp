package com.example.presentation.ui.main.orderConfirmation.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface OrderConfirmationEffect {
    data object NavigateToHome : OrderConfirmationEffect

    data class Error(val errorMessage: String) : OrderConfirmationEffect
}