package com.example.presentation.ui.splash.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class SplashViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<SplashScreenState, SplashEffect> {

    override val container = container<SplashScreenState, SplashEffect>(
        initialState = SplashScreenState.INITIAL
    )
}