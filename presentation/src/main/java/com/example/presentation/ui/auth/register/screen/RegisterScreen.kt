package com.example.presentation.ui.auth.register.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.auth.register.mvi.RegisterEffect
import com.example.presentation.ui.auth.register.mvi.RegisterViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val registerScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is RegisterEffect.NavigateToHome -> onNavigateToHome()
            is RegisterEffect.NavigateToLogin -> onNavigateToLogin()
            is RegisterEffect.Error -> {}
        }
    }

    RegisterScreenContent(
        stateProvider = { registerScreenState },
        onUsernameChange = viewModel::onUsernameChange,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onRegisterClick = viewModel::onRegisterClick,
        onLoginClick = viewModel::onLoginClick
    )
}