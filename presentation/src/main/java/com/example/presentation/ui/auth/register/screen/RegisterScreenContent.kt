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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.presentation.base.focusOn
import com.example.presentation.ui.auth.common.AuthFooter
import com.example.presentation.ui.auth.common.AuthHeader
import com.example.presentation.ui.auth.common.AuthInputGroup
import com.example.presentation.ui.auth.common.RememberMeCheckBox
import com.example.presentation.ui.auth.register.mvi.RegisterScreenState
import com.example.presentation.ui.common.PrimaryButton
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun RegisterScreenContent(
    stateProvider: () -> RegisterScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRememberMeChange: (Boolean) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val usernameProvider = stateProvider.focusOn { username }
    val emailProvider = stateProvider.focusOn { email }
    val passwordProvider = stateProvider.focusOn { password }
    val flagRememberMeProvider = stateProvider.focusOn { flagRememberMe }

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
            stateProvider = usernameProvider,
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            password = false,
            onValueChange = onUsernameChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            stateProvider = emailProvider,
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            onValueChange = onEmailChange
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Password",
            stateProvider = passwordProvider,
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            onValueChange = onPasswordChange
        )

        RememberMeCheckBox(
            stateProvider = flagRememberMeProvider,
            onRememberMeChange = onRememberMeChange
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
    val registerScreenState = RegisterScreenState()

    ShoppingAppTheme {
        RegisterScreenContent(
            stateProvider = { registerScreenState },
            onUsernameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onRememberMeChange = {},
            onRegisterClick = {},
            onLoginClick = {}
        )
    }
}

