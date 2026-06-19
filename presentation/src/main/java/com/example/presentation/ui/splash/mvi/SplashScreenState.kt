package com.example.presentation.ui.splash.mvi

data class SplashScreenState(
    val flagRememberMe: Boolean = false,
    val username: String = "Narmin",
    val errorMessage: String? = null
)