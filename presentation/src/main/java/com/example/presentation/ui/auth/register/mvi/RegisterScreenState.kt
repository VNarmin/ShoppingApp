package com.example.presentation.ui.auth.register.mvi

data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = RegisterScreenState()
    }
}