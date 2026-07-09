package com.example.presentation.ui.main.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.presentation.base.read
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class CategoryFilterState(
    val categoryStates: ImmutableList<CategoryState>
)

@Composable
internal fun CategoryFilter(
    modifier: Modifier = Modifier,
    stateProvider: () -> CategoryFilterState,
    onCategoryChange: (String) -> Unit
) {
    val categoryStates = stateProvider.read { categoryStates }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(
            items = categoryStates,
            key = { categoryState -> categoryState.categoryID }
        ) { categoryState ->
            CategoryCard(
                stateProvider = { categoryState },
                onClick = { onCategoryChange(categoryState.categoryID) }
            )
        }
    }
}

internal data class CategoryState(
    val categoryID: String,
    val categoryLabel: String,
    val categorySelected: Boolean
)

@Composable
private fun CategoryCard(
    stateProvider: () -> CategoryState,
    onClick: () -> Unit
) {
    val categoryLabel = stateProvider.read { categoryLabel }
    val categorySelected = stateProvider.read { categorySelected }

    val backgroundColor = if (categorySelected) Color(0xFF6366F1) else Color(0xFF16161A)
    val textColor = if (categorySelected) Color(0xFFFFFFFF) else Color(0xFF6B6B70)
    val borderColor = if (categorySelected) Color.Transparent else Color(0xFF2A2A2E)
    val fontWeight = if (categorySelected) FontWeight.SemiBold else FontWeight.Medium

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .border(
                color = borderColor,
                shape = RoundedCornerShape(100.dp),
                width = 1.dp
            )
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = categoryLabel,
            style = TextStyle(
                color = textColor,
                fontFamily = DMSansFontFamily,
                fontSize = 13.sp,
                fontWeight = fontWeight,
                textAlign = TextAlign.Center
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun SelectedCategoryCardPreview() {
    val categoryState = CategoryState(
        categoryID = "shoes",
        categoryLabel = "Shoes",
        categorySelected = true
    )

    ShoppingAppTheme {
        CategoryCard(
            stateProvider = { categoryState },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun UnselectedCategoryCardPreview() {
    val categoryState = CategoryState(
        categoryID = "shoes",
        categoryLabel = "Shoes",
        categorySelected = false
    )

    ShoppingAppTheme {
        CategoryCard(
            stateProvider = { categoryState },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun CategoryFilterPreview() {
    val categoryStates = persistentListOf(
        CategoryState(categoryID = "all",         categoryLabel = "All",         categorySelected = true),
        CategoryState(categoryID = "shoes",       categoryLabel = "Shoes",       categorySelected = false),
        CategoryState(categoryID = "bags",        categoryLabel = "Bags",        categorySelected = false),
        CategoryState(categoryID = "watches",     categoryLabel = "Watches",     categorySelected = false),
        CategoryState(categoryID = "tech",        categoryLabel = "Tech",        categorySelected = false),
        CategoryState(categoryID = "beauty",      categoryLabel = "Beauty",      categorySelected = false),
        CategoryState(categoryID = "sports",      categoryLabel = "Sports",      categorySelected = false),
        CategoryState(categoryID = "clothing",    categoryLabel = "Clothing",    categorySelected = false),
        CategoryState(categoryID = "accessories", categoryLabel = "Accessories", categorySelected = false)
    )

    val categoryFilterState = CategoryFilterState(
        categoryStates = categoryStates,
    )

    ShoppingAppTheme {
        CategoryFilter(
            stateProvider = { categoryFilterState },
            onCategoryChange = {},
        )
    }
}