package com.example.presentation.ui.auth.register.mvi

internal data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val flagRememberMe: Boolean = false,
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val canRegister : Boolean = false
) {
    companion object {
        val INITIAL = RegisterScreenState()
    }
}