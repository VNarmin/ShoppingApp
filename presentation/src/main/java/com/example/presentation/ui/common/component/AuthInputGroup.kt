package com.example.presentation.ui.common.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun AuthInputGroup(
    prompt : String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    isPassword: Boolean = false
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
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            isPassword = isPassword
        )
    }
}

@Preview
@Composable
private fun EmailInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Email",
            value = "",
            onValueChange = {},
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            isPassword = false
        )
    }
}

@Preview
@Composable
private fun PasswordInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Password",
            value = "",
            onValueChange = {},
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Password,
            isPassword = true
        )
    }
}

@Preview
@Composable
private fun UsernameInputGroupPreview() {
    ShoppingAppTheme {
        AuthInputGroup(
            prompt = "Username",
            value = "",
            onValueChange = {},
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            isPassword = false
        )
    }
}