package com.example.presentation.ui.auth.login.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel(), ContainerHost<LoginScreenState, LoginEffect> {

    override val container = container<LoginScreenState, LoginEffect>(
        initialState = LoginScreenState.INITIAL
    )

    fun onEmailChange(email: String) = intent {
        reduce {
            state.copy(
                email = email,
                errorMessage = null,
                canLogin = canLogin(
                    email = email,
                    password = state.password,
                    loading = state.loading
                )
            )
        }
    }

    fun onPasswordChange(password: String) = intent {
        reduce {
            state.copy(
                password = password,
                errorMessage = null,
                canLogin = canLogin(
                    email = state.email,
                    password = password,
                    loading = state.loading
                )
            )
        }
    }

    fun onRememberMeChange(flagRememberMe: Boolean) = intent {
        reduce { state.copy(flagRememberMe = flagRememberMe) }
    }

    fun onLoginClick() = intent {
        val email = state.email
        val password = state.password

        if (email.isBlank() && password.isBlank()) {
            val message = "Please fill in all required fields."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(LoginEffect.Error(errorMessage = message))
            return@intent
        }
        if (email.isBlank()) {
            val message = "Please enter your email address to continue."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(LoginEffect.Error(errorMessage = message))
            return@intent
        }
        if (password.isBlank()) {
            val message = "Please enter your password to continue."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(LoginEffect.Error(errorMessage = message))
            return@intent
        }

        reduce { state.copy(loading = true, errorMessage = null) }

        authRepository.login(
            email = email,
            password = password
        ).catch { error ->
            val message = error.message ?: "Something went wrong during authentication."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(LoginEffect.Error(errorMessage = message))
        }.collect {
            authRepository.setRememberMe(flagRememberMe = state.flagRememberMe)
            reduce { state.copy(loading = false) }
            postSideEffect(LoginEffect.NavigateToHome)
        }
    }

    private fun canLogin(
        email: String,
        password: String,
        loading: Boolean
    ): Boolean = email.isNotBlank() && password.isNotBlank() && !loading

    fun onRegisterClick() = intent {
        postSideEffect(LoginEffect.NavigateToRegister)
    }
}