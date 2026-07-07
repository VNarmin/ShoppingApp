package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun PrimaryButton(
    modifier: Modifier = Modifier,
    command: String,
    stateProvider: () -> Boolean,
    onClick: () -> Unit,
) {
    val enabled = stateProvider.read { this }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .then(
                if (enabled) {
                    Modifier.dropShadow(
                        shape = RoundedCornerShape(14.dp),
                        shadow = Shadow(
                            radius = 24.dp,
                            spread = 2.dp,
                            color = Color(0xFF6366F1).copy(alpha = 0.20F),
                            offset = DpOffset(0.dp, 8.dp)
                        )
                    )
                } else {
                    Modifier.border(
                        color = Color(0xFF3A3A40),
                        shape = RoundedCornerShape(14.dp),
                        width = 1.dp
                    )
                }
            )
            .clip(RoundedCornerShape(14.dp))
            .background(if (enabled) Color(0xFF6366F1) else Color(0xFF16161A))
            .clickable(enabled = enabled, onClick = onClick)
    ) {
        Text(
            text = command,
            style = TextStyle(
                color = if (enabled) Color(0xFFFFFFFF) else (Color(0xFF6366F1)),
                fontFamily = DMSansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun EnabledPrimaryButtonPreview() {
    ShoppingAppTheme {
        PrimaryButton(
            command = "Continue",
            stateProvider = { true },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun DisabledPrimaryButtonPreview() {
    ShoppingAppTheme {
        PrimaryButton(
            command = "Continue",
            stateProvider = { false },
            onClick = {}
        )
    }
}