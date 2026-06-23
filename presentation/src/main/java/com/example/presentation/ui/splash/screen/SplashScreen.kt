package com.example.presentation.ui.splash.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.splash.mvi.SplashEffect
import com.example.presentation.ui.splash.mvi.SplashViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    onNavigateForward: () -> Unit
) {
    val splashScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is SplashEffect.NavigateForward -> onNavigateForward()
            is SplashEffect.Error -> {}
        }
    }
}