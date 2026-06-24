package com.example.presentation.ui.splash.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import kotlin.time.Duration.Companion.milliseconds

internal class SplashViewModel(
    private val authRepository: AuthRepository
) : ViewModel(), ContainerHost<Unit, SplashEffect> {

    override val container = container<Unit, SplashEffect>(initialState = Unit)

    init { navigateForward() }

    private fun navigateForward() = intent {
        delay(duration = 2000.milliseconds)
        try {
            val shouldSkipAuth = authRepository.shouldSkipAuth()
            postSideEffect(
                if (shouldSkipAuth) SplashEffect.NavigateToMain
                else SplashEffect.NavigateToAuth
            )
        } catch (error: Exception) {
            val message = error.message ?: "Something went wrong."
            postSideEffect(SplashEffect.Error(errorMessage = message))
        }
    }
}