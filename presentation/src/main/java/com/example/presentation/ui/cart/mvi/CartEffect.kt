package com.example.presentation.ui.cart.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CartEffect {
    data object NavigateBack : CartEffect
    data object NavigateToCheckout : CartEffect

    data class Error(val errorMessage: String) : CartEffect
}