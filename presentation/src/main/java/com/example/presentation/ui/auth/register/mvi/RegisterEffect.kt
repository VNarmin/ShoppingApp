package com.example.presentation.ui.auth.register.mvi

import androidx.compose.runtime.Immutable

@Immutable
sealed interface RegisterEffect {
    data object NavigateToHome : RegisterEffect
    data object NavigateToLogin : RegisterEffect

    data class Error(val errorMessage: String) : RegisterEffect
}