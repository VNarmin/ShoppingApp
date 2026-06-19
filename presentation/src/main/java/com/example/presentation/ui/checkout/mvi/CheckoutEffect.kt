package com.example.presentation.ui.checkout.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CheckoutEffect {
    data object NavigateToBack : CheckoutEffect
    data object NavigateToOrderConfirmation : CheckoutEffect
    data class Error(val errorMessage: String) : CheckoutEffect
}