package com.example.presentation.ui.splash.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class SplashViewModel(
    override val container: Container<SplashScreenState, SplashEffect>
) : ViewModel(), ContainerHost<SplashScreenState, SplashEffect> {

}