package com.example.presentation.ui.auth.login.mvi

internal data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val flagRememberMe: Boolean = false,
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val canLogin: Boolean = false
) {
    companion object {
        val INITIAL = LoginScreenState()
    }
}