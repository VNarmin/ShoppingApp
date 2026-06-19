package com.example.presentation.ui.categoryDetail.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Category
import com.example.presentation.base.read
import com.example.presentation.ui.categoryDetail.mvi.CategoryDetailScreenState
import com.example.presentation.ui.common.IconButton
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun CategoryDetailHeader(
    stateReader: () -> CategoryDetailScreenState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentCategory = stateReader.read { currentCategory }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = onBackClick
        )
        Text(
            text = currentCategory.displayName,
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )
        IconButton(
            icon = Icons.Default.Tune,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun CategoryDetailHeaderPreview() {
    val currentCategory = Category(
        categoryID = "shoes",
        displayName = "Shoes",
        itemCount = 128
    )

    val categoryDetailScreenState = CategoryDetailScreenState(
        currentCategory = currentCategory
    )

    ShoppingAppTheme {
        CategoryDetailHeader(
            stateReader = { categoryDetailScreenState },
            onBackClick = {}
        )
    }
}