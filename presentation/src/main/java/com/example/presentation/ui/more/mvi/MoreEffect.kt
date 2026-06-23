package com.example.presentation.ui.more.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface MoreEffect {
    data class NavigateToCategoryDetail(val categoryID: String) : MoreEffect
    data object NavigateToHome : MoreEffect
    data class Error(val errorMessage: String) : MoreEffect
}