package com.example.presentation.ui.categoryDetail.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CategoryDetailEffect {
    data object NavigateToMore : CategoryDetailEffect
    data object NavigateToProductDetail : CategoryDetailEffect
    data object NavigateToHome : CategoryDetailEffect
    data class Error(val errorMessage: String) : CategoryDetailEffect
}