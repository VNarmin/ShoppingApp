package com.example.presentation.ui.auth.login.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface LoginEffect {
    data object NavigateToHome : LoginEffect
    data object NavigateToRegister : LoginEffect
    data class Error(val message: String) : LoginEffect
}