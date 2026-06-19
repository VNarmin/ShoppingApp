package com.example.presentation.ui.more.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface MoreEffect {
    data object NavigateToCategoryDetail : MoreEffect
    data object NavigateToHome : MoreEffect
    data class Error(val errorMessage: String) : MoreEffect
}