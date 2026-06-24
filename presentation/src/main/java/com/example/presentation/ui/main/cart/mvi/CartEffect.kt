package com.example.presentation.ui.main.cart.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CartEffect {
    data object NavigateBack : CartEffect
    data object NavigateToCheckout : CartEffect

    data class Error(val errorMessage: String) : CartEffect
}