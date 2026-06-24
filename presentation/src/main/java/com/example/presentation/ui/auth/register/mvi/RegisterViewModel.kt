package com.example.presentation.ui.auth.register.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class RegisterViewModel(
    private val authRepository: AuthRepository
) : ViewModel(), ContainerHost<RegisterScreenState, RegisterEffect> {

    override val container = container<RegisterScreenState, RegisterEffect>(
        initialState = RegisterScreenState.INITIAL
    )

    fun onUsernameChange(username: String) = intent {
        reduce { state.copy(username = username, errorMessage = null) }
    }

    fun onEmailChange(email: String) = intent {
        reduce { state.copy(email = email, errorMessage = null) }
    }

    fun onPasswordChange(password: String) = intent {
        reduce { state.copy(password = password, errorMessage = null) }
    }

    fun onRememberMeChange(flagRememberMe: Boolean) = intent {
        reduce { state.copy(flagRememberMe = flagRememberMe) }
    }

    fun onRegisterClick() = intent {
        val username = state.username
        val email = state.email
        val password = state.password

        val blankCount = listOf(username, email, password).count { input ->
            input.isBlank()
        }

        if (blankCount > 1) {
            val message = "Please fill in all required fields."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(RegisterEffect.Error(errorMessage = message))
            return@intent
        }
        if (username.isBlank()) {
            val message = "Please enter your username to continue."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(RegisterEffect.Error(errorMessage = message))
            return@intent
        }
        if (email.isBlank()) {
            val message = "Please enter your email address to continue."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(RegisterEffect.Error(errorMessage = message))
            return@intent
        }
        if (password.isBlank()) {
            val message = "Please enter your password to continue."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(RegisterEffect.Error(errorMessage = message))
            return@intent
        }

        reduce { state.copy(loading = true, errorMessage = null) }

        authRepository.register(
            username = username,
            email = email,
            password = password
        ).catch { error ->
            val message = error.message ?: "Something went wrong during registration."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(RegisterEffect.Error(errorMessage = message))
        }.collect {
            authRepository.setRememberMe(flagRememberMe = state.flagRememberMe)
            reduce { state.copy(loading = false) }
            postSideEffect(RegisterEffect.NavigateToHome)
        }
    }

    fun onLoginClick() = intent {
        postSideEffect(RegisterEffect.NavigateToLogin)
    }
}