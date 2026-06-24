package com.example.presentation.ui.main.categoryDetail.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CategoryDetailEffect {
    data object NavigateToMore : CategoryDetailEffect
    data class NavigateToProductDetail(val productID : String) : CategoryDetailEffect

    data object NavigateToHome : CategoryDetailEffect

    data class Error(val errorMessage: String) : CategoryDetailEffect
}