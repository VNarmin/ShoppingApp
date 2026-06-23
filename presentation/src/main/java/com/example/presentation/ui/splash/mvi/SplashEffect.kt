package com.example.presentation.ui.splash.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface SplashEffect {
    data object NavigateForward : SplashEffect

    data class Error(val errorMessage: String) : SplashEffect
}