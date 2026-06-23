package com.example.presentation.ui.home.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.presentation.ui.home.mvi.HomeEffect
import com.example.presentation.ui.home.mvi.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun HomeScreen(
    viewModel : HomeViewModel = koinViewModel(),
    onNavigateToCart: () -> Unit,
    onNavigateToProductDetail: (String) -> Unit,
    onNavigateToMore: () -> Unit
) {
    val homeScreenState = viewModel.collectAsState().value

    // the Unit key means it only fires once when the screen enters the composition
    LaunchedEffect(Unit) {
        viewModel.loadScreen()
    }

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is HomeEffect.NavigateToCart -> onNavigateToCart()
            is HomeEffect.NavigateToProductDetail -> onNavigateToProductDetail(effect.productID)
            is HomeEffect.NavigateToMore -> onNavigateToMore()
            is HomeEffect.Error -> {}
        }
    }

    HomeScreenContent(
        stateProvider = { homeScreenState },
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onCartClick = viewModel::onCartClick,
        onCategoryChange = viewModel::onCategoryChange,
        onProductClick = viewModel::onProductClick,
        onMoreClick = viewModel::onMoreClick
    )
}