package com.example.presentation.ui.common

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun PrimaryButton(
    command: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                shadow = Shadow(
                    radius = 8.dp, // blur softness
                    spread = 2.dp,  // shadow expansion
                    color = Color(0xFF6366F1).copy(alpha = 0.50F),
                    offset = DpOffset(0.dp, 0.dp)
                )
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF6366F1))
            .clickable(enabled = enabled, onClick = onClick)
    ) {
        Text(
            text = command,
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontFamily = DMSansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    ShoppingAppTheme {
        PrimaryButton(
            command = "Continue",
            onClick = {}
        )
    }
}