package com.example.presentation.ui.auth.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun RememberMeCheckBox(
    modifier: Modifier = Modifier,
    stateProvider: () -> Boolean,
    onRememberMeChange: (Boolean) -> Unit
) {
    val flagRememberMe = stateProvider.read { this }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF6366F1),
                uncheckedColor = Color(0xFF6366F1),
            ),
            checked = flagRememberMe,
            onCheckedChange = onRememberMeChange
        )
        Text(
            text = "Remember Me",
            style = TextStyle(
                color = Color(0xFF6366F1),
                fontFamily = DMSansFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun RememberMeCheckBoxPreviewCaseTrue() {
    ShoppingAppTheme {
        RememberMeCheckBox(
            stateProvider = { true },
            onRememberMeChange = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun RememberMeCheckBoxPreviewCaseFalse() {
    ShoppingAppTheme {
        RememberMeCheckBox(
            stateProvider = { false },
            onRememberMeChange = {}
        )
    }
}