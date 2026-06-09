package com.example.presentation.ui.auth.login.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel(), ContainerHost<LoginScreenState, LoginEffect> {
    override val container = container<LoginScreenState, LoginEffect>(LoginScreenState.INITIAL)

    fun onEmailChange(email: String) = intent {
        reduce { state.copy(email = email, error = null) }
    }

    fun onPasswordChange(password: String) = intent {
        reduce { state.copy(password = password, error = null) }
    }

    private fun login() = intent {
        val email = state.email
        val password = state.password

        if (email.isBlank()) {
            reduce { state.copy(error = "Email is required") }
            return@intent
        }
        if (password.isBlank()) {
            reduce { state.copy(error = "Password is required") }
            return@intent
        }

        reduce { state.copy(loading = true) }

        authRepository.login(
            emailAddress = email,
            password = password
        ).catch { error ->
            reduce { state.copy(loading = false, error = "Failed Authentication")}
            postSideEffect(LoginEffect.ShowError(error.message ?: state.error!!))
        }.collect { user ->
            reduce {state.copy(loading = false)}
            postSideEffect(LoginEffect.NavigateToHome)
        }
    }
}