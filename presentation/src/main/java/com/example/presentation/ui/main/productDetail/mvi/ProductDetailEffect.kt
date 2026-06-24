package com.example.presentation.ui.main.productDetail.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface ProductDetailEffect {
    data object NavigateBack : ProductDetailEffect
    data object NavigateToCart : ProductDetailEffect
    data object NavigateToCheckout : ProductDetailEffect

    data class Error(val errorMessage: String) : ProductDetailEffect
}