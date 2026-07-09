package com.example.presentation.ui.auth.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.ui.common.IconButton
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

private const val loginTitle = "Welcome Back"
private const val registerTitle = "Welcome Aboard"

private const val loginSubtitle = "Sign in to continue shopping"
private const val registerSubtitle = "Create an account to start shopping"

@Composable
internal fun AuthHeader(
    modifier: Modifier = Modifier,
    register: Boolean = false,
    onSwitchAuthTab: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        IconButton(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = {}
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = if (!register) loginTitle else registerTitle,
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )

            Text(
                text = if (!register) loginSubtitle else registerSubtitle,
                style = TextStyle(
                    color = Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            )
        }

        AuthTabs(
            register = register,
            onSwitchAuthTab = onSwitchAuthTab,
        )
    }
}

@Composable
private fun AuthTabs(
    modifier: Modifier = Modifier,
    register: Boolean = false,
    onSwitchAuthTab: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(size = 12.dp),
                width = 1.dp
            )
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(if (!register) Color(0xFF6366F1) else Color(0xFF16161A))
                .clickable(enabled = register, onClick = onSwitchAuthTab)
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    color = if (!register) Color(0xFFFFFFFF) else Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(if (register) Color(0xFF6366F1) else Color(0xFF16161A))
                .clickable(enabled = !register, onClick = onSwitchAuthTab)
        ) {
            Text(
                text = "Register",
                style = TextStyle(
                    color = if (register) Color(0xFFFFFFFF) else Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun LoginAuthHeaderPreview() {
    ShoppingAppTheme {
        AuthHeader(
            register = false,
            onSwitchAuthTab = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun RegisterAuthHeaderPreview() {
    ShoppingAppTheme {
        AuthHeader(
            register = true,
            onSwitchAuthTab = {}
        )
    }
}