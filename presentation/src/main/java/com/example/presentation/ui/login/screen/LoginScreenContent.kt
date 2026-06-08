package com.example.presentation.ui.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.ui.common.component.AuthFooter
import com.example.presentation.ui.common.component.AuthHeader
import com.example.presentation.ui.common.component.AuthInputGroup

@Composable
fun LoginScreenContent() {
    Scaffold(
        containerColor = Color(0xFF0B0B0E),
        contentWindowInsets = WindowInsets(0.dp),
        content = { _ ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                AuthHeader(
                    modifier = Modifier.fillMaxWidth(),
                    registerTabSelected = false,
                    onLoginClicked = { },
                    onRegisterClicked = { }
                )

                AuthInputGroup(
                    prompt = "Email",
                    value = "",
                    onValueChange = {},
                    placeholder = "you@email.com",
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = Icons.Default.Email,
                    isPassword = false
                )

                AuthInputGroup(
                    prompt = "Password",
                    value = "",
                    onValueChange = {},
                    placeholder = "••••••••",
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = Icons.Default.Password,
                    isPassword = true
                )

                AuthFooter(
                    onActionClicked = {},
                    modifier = Modifier.fillMaxWidth(),
                    registerTabSelected = false
                )
                
            }
        }
    )
}

@Preview
@Composable
private fun LoginScreenContentPreview() {
    LoginScreenContent()
}

