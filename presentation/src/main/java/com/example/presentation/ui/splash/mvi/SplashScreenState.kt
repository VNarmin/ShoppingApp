package com.example.presentation.ui.splash.mvi

data class SplashScreenState(
    val flagRememberMe: Boolean = false,
    val username: String = "",
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = SplashScreenState()
    }
}