package com.example.presentation.ui.auth.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.ui.common.InputField
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun AuthInputGroup(
    modifier: Modifier = Modifier,
    prompt: String,
    stateProvider: () -> String,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    password: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = prompt,
            style = TextStyle(
                color = Color(0xFF8E8E93),
                fontFamily = DMSansFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
        )

        InputField(
            stateProvider = stateProvider,
            onValueChange = onValueChange,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            password = password
        )
    }
}

@PreviewLightDark
@Composable
private fun EmailInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Email",
            stateProvider = { "" },
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false,
            onValueChange = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun PasswordInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Password",
            stateProvider = { "" },
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            password = true,
            onValueChange = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun UsernameInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Username",
            stateProvider = { "" },
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            password = false,
            onValueChange = {}
        )
    }
}