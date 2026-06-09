package com.example.presentation.ui.auth.register.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class RegisterViewModel(
    private val authRepository: AuthRepository
) : ViewModel(), ContainerHost<RegisterScreenState, RegisterEffect> {

    override val container = container<RegisterScreenState, RegisterEffect>(RegisterScreenState.INITIAL)

    fun onUsernameChange(username : String) = intent {
        reduce { state.copy(username = username) }
    }

    fun onEmailChange(email: String) = intent {
        reduce { state.copy(email = email, error = null) }
    }

    fun onPasswordChange(password: String) = intent {
        reduce { state.copy(password = password, error = null) }
    }

    private fun register() = intent {
        val username = state.username
        val email = state.email
        val password = state.password

        if (username.isBlank()) {
            reduce { state.copy(error = "Username is required") }
            return@intent
        }
        if (email.isBlank()) {
            reduce { state.copy(error = "Email is required") }
            return@intent
        }
        if (password.isBlank()) {
            reduce { state.copy(error = "Password is required") }
            return@intent
        }

        reduce { state.copy(loading = true) }

        authRepository.register(
            username = username,
            emailAddress = email,
            password = password
        ).catch { error ->
            reduce { state.copy(loading = false, error = "Failed Registration")}
            postSideEffect(RegisterEffect.ShowError(error.message ?: state.error!!))
        }.collect { user ->
            reduce {state.copy(loading = false)}
            postSideEffect(RegisterEffect.NavigateToHome)
        }
    }
}