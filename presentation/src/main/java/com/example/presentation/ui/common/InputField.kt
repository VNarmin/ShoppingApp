package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun InputField(
    stateProvider: () -> String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    password: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current
) {
    val value = stateProvider.read { this }
    var passwordVisible by remember { mutableStateOf(false) }
    var focused by remember { mutableStateOf(false) }

    val borderColor = if (focused) Color(0xFF6366F1) else Color(0xFF2A2A2E)

    val borderWidth = if (focused) 2.dp else 1.dp

    val iconTint = if (focused) Color(0xFFFAFAF9) else Color(0xFF6B6B70)

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF16161A))
            .border(
                color = borderColor,
                shape = RoundedCornerShape(12.dp),
                width = borderWidth
            )
            .padding(horizontal = 16.dp)
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState -> focused = focusState.isFocused },
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation =
                if (password && !passwordVisible) PasswordVisualTransformation()
                else VisualTransformation.None,
            textStyle = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = if (password) KeyboardType.Password
                else KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            cursorBrush = SolidColor(Color(0xFF6366F1)),
            decorationBox = { innerTextField ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (leadingIcon != null) {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = iconTint,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    color = Color(0xFF4A4A50),
                                    fontFamily = DMSansFontFamily,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Start
                                )
                            )
                        }
                        innerTextField()
                    }
                    if (password) {
                        Icon(
                            imageVector =
                                if (passwordVisible) Icons.Default.Visibility
                                else Icons.Default.VisibilityOff,
                            contentDescription = null,
                            tint = iconTint,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable { passwordVisible = !passwordVisible }
                        )
                    }
                }
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun EmailInputFieldPreview() {
    ShoppingAppTheme {
        InputField(
            stateProvider = { "" },
            onValueChange = {},
            placeholder = "you@email.com",
            leadingIcon = Icons.Default.Email,
            password = false
        )
    }
}

@PreviewLightDark
@Composable
private fun PasswordInputFieldPreview() {
    ShoppingAppTheme {
        InputField(
            stateProvider = { "" },
            onValueChange = {},
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Lock,
            password = true
        )
    }
}

@PreviewLightDark
@Composable
private fun UsernameInputFieldPreview() {
    ShoppingAppTheme {
        InputField(
            stateProvider = { "" },
            onValueChange = {},
            placeholder = "username",
            leadingIcon = Icons.Default.Person,
            password = false
        )
    }
}