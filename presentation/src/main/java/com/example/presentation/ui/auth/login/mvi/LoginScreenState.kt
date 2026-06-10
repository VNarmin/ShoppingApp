package com.example.presentation.ui.auth.login.mvi

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = LoginScreenState()
    }
}