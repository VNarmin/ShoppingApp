package com.example.presentation.ui.auth.login.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.base.read
import com.example.presentation.ui.auth.common.AuthFooter
import com.example.presentation.ui.auth.common.AuthHeader
import com.example.presentation.ui.auth.common.AuthInputGroup
import com.example.presentation.ui.auth.login.mvi.LoginScreenState
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun LoginScreenContent(
    stateReader: () -> LoginScreenState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    val emailValue = stateReader.read { email }
    val passwordValue = stateReader.read { password }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
            value = emailValue,
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            onValueChange = onEmailChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Password",
            value = passwordValue,
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            onValueChange = onPasswordChange
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            command = "Sign In",
            onClick = onLoginClick
        )

        AuthFooter(
            modifier = Modifier.fillMaxWidth(),
            register = false,
            onActionClick = onRegisterClick
        )
    }
}

@Preview
@Composable
private fun LoginScreenContentPreview() {
    ShoppingAppTheme {
        val loginScreenState = LoginScreenState()
        LoginScreenContent(
            stateReader = { loginScreenState },
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}