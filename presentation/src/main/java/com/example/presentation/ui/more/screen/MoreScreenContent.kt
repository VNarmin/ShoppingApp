package com.example.presentation.ui.more.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.domain.model.Category
import com.example.presentation.ui.common.BottomNavBar
import com.example.presentation.ui.more.mvi.MoreScreenState
import com.example.presentation.ui.more.widget.MoreBody
import com.example.presentation.ui.more.widget.MoreHeader
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun MoreScreenContent(
    stateProvider: () -> MoreScreenState,
    onCategoryClick: (String) -> Unit,
    onHomeClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            MoreHeader()
        },
        content = { innerPadding ->
            MoreBody(
                stateProvider = stateProvider,
                onCategoryClick = onCategoryClick,
                modifier = Modifier.padding(innerPadding)
            )
        },
        bottomBar = {
            BottomNavBar(
                more = true,
                onSwitchTab = onHomeClick
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun MoreScreenContentPreview() {
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

    val moreScreenState = MoreScreenState(
        username = "Olivia Rodrigo",
        categories = categories,
    )

    ShoppingAppTheme {
        MoreScreenContent(
            stateProvider = { moreScreenState },
            onCategoryClick = {},
            onHomeClick = {}
        )
    }
}