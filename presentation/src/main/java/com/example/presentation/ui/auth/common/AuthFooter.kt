package com.example.presentation.ui.auth.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

private const val loginFooterText = "New here? "
private const val loginFooterAction = "Create an account"

private const val registerFooterText = "Already have an account? "
private const val registerFooterAction = "Sign in"

@Composable
internal fun AuthFooter(
    modifier: Modifier = Modifier,
    register: Boolean = false,
    onActionClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFF2A2A2E))
            Text(
                text = "or",
                style = TextStyle(
                    color = Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            )
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFF2A2A2E))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialButton(
                label = "Google",
                icon = Icons.Default.Language,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            SocialButton(
                label = "Apple",
                icon = Icons.Default.AlternateEmail,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
        }

        Row {
            Text(
                text = if (!register) loginFooterText else registerFooterText,
                style = TextStyle(
                    color = Color(0xFF6B6B70),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                modifier = Modifier.clickable(onClick = onActionClick),
                text = if (!register) loginFooterAction else registerFooterAction,
                style = TextStyle(
                    color = Color(0xFF6366F1),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@Composable
private fun SocialButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(12.dp),
                width = 1.dp
            )
            .clickable(onClick = onClick)
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFFFAFAF9)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun LoginAuthFooterPreview() {
    ShoppingAppTheme {
        AuthFooter(
            register = false,
            onActionClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun RegisterAuthFooterPreview() {
    ShoppingAppTheme {
        AuthFooter(
            register = true,
            onActionClick = {}
        )
    }
}