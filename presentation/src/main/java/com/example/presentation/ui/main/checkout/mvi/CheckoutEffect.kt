package com.example.presentation.ui.main.checkout.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CheckoutEffect {
    data object NavigateBack : CheckoutEffect
    data object NavigateToOrderConfirmation : CheckoutEffect

    data class Error(val errorMessage: String) : CheckoutEffect
}