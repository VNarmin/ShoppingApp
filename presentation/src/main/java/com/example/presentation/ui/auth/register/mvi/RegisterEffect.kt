package com.example.presentation.ui.auth.register.mvi

import androidx.compose.runtime.Immutable

@Immutable
sealed interface RegisterEffect {
    data object NavigateToHome : RegisterEffect
    data object NavigateToLogin : RegisterEffect
    data class ShowError(val message: String) : RegisterEffect
}