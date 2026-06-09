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
import androidx.compose.ui.unit.dp
import com.example.presentation.ui.auth.common.AuthFooter
import com.example.presentation.ui.auth.common.AuthHeader
import com.example.presentation.ui.auth.common.AuthInputGroup
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun RegisterScreenContent() {
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
            onLoginClick = {},
            onRegisterClick = {}
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            value = "",
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            password = false,
            onValueChange = {}
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Email",
            value = "",
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            onValueChange = {}
        )

        AuthInputGroup(
            modifier = Modifier.fillMaxWidth(),
            prompt = "Password",
            value = "",
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            onValueChange = {}
        )

        AuthFooter(
            modifier = Modifier.fillMaxWidth(),
            register = true,
            onActionClick = {}
        )
    }
}

@Preview
@Composable
private fun RegisterScreenContentPreview() {
    ShoppingAppTheme {
        RegisterScreenContent()
    }
}

