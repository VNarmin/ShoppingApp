package com.example.presentation.ui.splash.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import kotlin.time.Duration.Companion.milliseconds

internal class SplashViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<SplashScreenState, SplashEffect> {

    override val container = container<SplashScreenState, SplashEffect>(
        initialState = SplashScreenState.INITIAL
    )

    init { navigateForward() }

    private fun navigateForward() = intent {
        delay(duration = 2000.milliseconds)
        postSideEffect(SplashEffect.NavigateForward)
    }
}