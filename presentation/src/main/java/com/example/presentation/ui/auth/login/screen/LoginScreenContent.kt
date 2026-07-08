package com.example.presentation.ui.auth.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.base.read
import com.example.presentation.ui.auth.common.AuthFooter
import com.example.presentation.ui.auth.common.AuthHeader
import com.example.presentation.ui.auth.common.AuthInputGroup
import com.example.presentation.ui.auth.common.RememberMeCheckBox
import com.example.presentation.ui.auth.login.mvi.LoginScreenState
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun LoginScreenContent(
    stateProvider: () -> LoginScreenState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRememberMeChange: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    val email = stateProvider.read { email }
    val password = stateProvider.read { password }
    val flagRememberMe = stateProvider.read { flagRememberMe }
    val canLogin = stateProvider.read { canLogin }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AuthHeader(
            modifier = Modifier.fillMaxWidth(),
            register = false,
            onSwitchAuthTab = onRegisterClick
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            value = email,
            onValueChange = onEmailChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Password",
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            value = password,
            onValueChange = onPasswordChange
        )

        RememberMeCheckBox(
            flagRememberMe = flagRememberMe,
            onRememberMeChange = onRememberMeChange
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            command = "Sign In",
            enabled = canLogin,
            onClick = onLoginClick
        )

        AuthFooter(
            modifier = Modifier.fillMaxWidth(),
            register = false,
            onActionClick = onRegisterClick
        )
    }
}

@PreviewLightDark
@Composable
private fun LoginScreenContentPreview() {
    val loginScreenState = LoginScreenState()

    ShoppingAppTheme {
        LoginScreenContent(
            stateProvider = { loginScreenState },
            onEmailChange = {},
            onPasswordChange = {},
            onRememberMeChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}