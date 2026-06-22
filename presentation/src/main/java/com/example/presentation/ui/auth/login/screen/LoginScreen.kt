package com.example.presentation.ui.auth.login.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.auth.login.mvi.LoginEffect
import com.example.presentation.ui.auth.login.mvi.LoginViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun LoginScreen(
    viewModel : LoginViewModel = koinViewModel(),
    onNavigateToHome : () -> Unit,
    onNavigateToRegister : () -> Unit
) {
    val loginScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is LoginEffect.NavigateToHome -> onNavigateToHome()
            is LoginEffect.NavigateToRegister -> onNavigateToRegister()
            is LoginEffect.Error -> {}
        }
    }

    LoginScreenContent(
        stateProvider = { loginScreenState },
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = viewModel::onLoginClick,
        onRegisterClick = viewModel::onRegisterClick
    )
}