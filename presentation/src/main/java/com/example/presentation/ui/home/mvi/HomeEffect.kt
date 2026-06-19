package com.example.presentation.ui.home.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface HomeEffect {
    data object NavigateToCart : HomeEffect
    data object NavigateToProductDetail : HomeEffect
    data object NavigateToMore : HomeEffect
    data class Error(val errorMessage: String) : HomeEffect
}