package com.example.presentation.ui.common

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
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
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun BottomNavBar(
    modifier: Modifier = Modifier,
    more: Boolean = false,
    onSwitchTab: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF1A1A1E))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(size = 24.dp),
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
                .clip(RoundedCornerShape(24.dp))
                .background(if (!more) Color(0xFF6366F1) else Color(0xFF1A1A1E))
                .clickable(enabled = more, onClick = onSwitchTab)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    modifier = Modifier.size(20.dp),
                    contentDescription = null,
                    tint = if (!more) Color(0xFFFFFFFF) else Color(0xFF6B6B6F)
                )
                Text(
                    text = "HOME",
                    style = TextStyle(
                        color = if (!more) Color(0xFFFFFFFF) else Color(0xFF6B6B6F),
                        fontFamily = DMSansFontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
                .clip(RoundedCornerShape(24.dp))
                .background(if (more) Color(0xFF6366F1) else Color(0xFF1A1A1E))
                .clickable(enabled = !more, onClick = onSwitchTab)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.GridView,
                    modifier = Modifier.size(20.dp),
                    contentDescription = null,
                    tint = if (more) Color(0xFFFFFFFF) else Color(0xFF6B6B6F)
                )
                Text(
                    text = "MORE",
                    style = TextStyle(
                        color = if (more) Color(0xFFFFFFFF) else Color(0xFF6B6B6F),
                        fontFamily = DMSansFontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeBottomNavBarPreview() {
    ShoppingAppTheme {
        BottomNavBar(
            more = false,
            onSwitchTab = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun MoreBottomNavBarPreview() {
    ShoppingAppTheme {
        BottomNavBar(
            more = true,
            onSwitchTab = {}
        )
    }
}