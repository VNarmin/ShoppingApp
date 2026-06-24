package com.example.presentation.ui.splash.mvi

import androidx.compose.runtime.Immutable

@Immutable
internal sealed class SplashEffect {
    data object NavigateToMain : SplashEffect()
    data object NavigateToAuth : SplashEffect()

    data class Error(val errorMessage: String) : SplashEffect()
}