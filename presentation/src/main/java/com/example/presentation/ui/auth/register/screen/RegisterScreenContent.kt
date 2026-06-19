package com.example.presentation.ui.auth.register.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.base.read
import com.example.presentation.ui.auth.common.AuthFooter
import com.example.presentation.ui.auth.common.AuthHeader
import com.example.presentation.ui.auth.common.AuthInputGroup
import com.example.presentation.ui.auth.register.mvi.RegisterScreenState
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun RegisterScreenContent(
    stateReader: () -> RegisterScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val username = stateReader.read { username }
    val email = stateReader.read { email }
    val password = stateReader.read { password }

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
            register = true,
            onSwitchAuthTab = onLoginClick,
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            value = username,
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            password = false,
            onValueChange = onUsernameChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            value = email,
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            onValueChange = onEmailChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Password",
            value = password,
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            onValueChange = onPasswordChange
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            command = "Register",
            onClick = onRegisterClick
        )

        AuthFooter(
            modifier = Modifier.fillMaxWidth(),
            register = true,
            onActionClick = onLoginClick
        )
    }
}

@PreviewLightDark
@Composable
private fun RegisterScreenContentPreview() {
    ShoppingAppTheme {
        val registerScreenState = RegisterScreenState()
        RegisterScreenContent(
            stateReader = { registerScreenState },
            onUsernameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onRegisterClick = {},
            onLoginClick = {}
        )
    }
}

