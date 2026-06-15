package com.example.presentation.ui.home.widget

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Category
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun CategoryFilter(
    categories: List<Category>,
    selectedCategoryID: String,
    onCategoryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(
            items = categories,
            key = { category -> category.categoryID }
        ) { category ->
            CategoryCard(
                label = category.displayName,
                selected = category.categoryID == selectedCategoryID,
                onClick = { onCategoryChange(category.categoryID) }
            )
        }
    }
}

@Composable
fun CategoryCard(
    label : String,
    selected : Boolean,
    onClick : () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF6366F1) else Color(0xFF16161A)
    val textColor = if (selected) Color(0xFFFFFFFF) else Color(0xFF6B6B70)
    val borderColor = if (selected) Color.Transparent else Color(0xFF2A2A2E)
    val fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium

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
            text = label,
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

@Preview
@Composable
private fun SelectedCategoryCardPreview() {
    ShoppingAppTheme {
        CategoryCard(
            label = "Shoes",
            selected = true,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun UnselectedCategoryCardPreview() {
    ShoppingAppTheme {
        CategoryCard(
            label = "Shoes",
            selected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun CategoryFilterPreview() {
    ShoppingAppTheme {
        val categories = listOf(
            Category(categoryID = "all",         displayName = "All",         itemCount = 926),
            Category(categoryID = "shoes",       displayName = "Shoes",       itemCount = 128),
            Category(categoryID = "bags",        displayName = "Bags",        itemCount = 86),
            Category(categoryID = "watches",     displayName = "Watches",     itemCount = 54),
            Category(categoryID = "tech",        displayName = "Tech",        itemCount = 210),
            Category(categoryID = "beauty",      displayName = "Beauty",      itemCount = 97),
            Category(categoryID = "sports",      displayName = "Sports",      itemCount = 64),
            Category(categoryID = "clothing",    displayName = "Clothing",    itemCount = 175),
            Category(categoryID = "accessories", displayName = "Accessories", itemCount = 112)
        )
        CategoryFilter(
            categories = categories,
            selectedCategoryID = "tech",
            onCategoryChange = {},
        )
    }
}