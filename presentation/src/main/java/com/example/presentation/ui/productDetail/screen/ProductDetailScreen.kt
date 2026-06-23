package com.example.presentation.ui.productDetail.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.productDetail.mvi.ProductDetailEffect
import com.example.presentation.ui.productDetail.mvi.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun ProductDetailScreen(
    viewModel : ProductDetailViewModel = koinViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToCart: () -> Unit,
    onNavigateToCheckout: () -> Unit
) {
    val productDetailScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is ProductDetailEffect.NavigateBack -> onNavigateBack()
            is ProductDetailEffect.NavigateToCart -> onNavigateToCart()
            is ProductDetailEffect.NavigateToCheckout -> onNavigateToCheckout()
            is ProductDetailEffect.Error -> {}
        }
    }

    ProductDetailScreenContent(
        stateProvider = { productDetailScreenState },
        onBackClick = viewModel::onBackClick,
        onCartClick = viewModel::onCartClick,
        onReadMoreClick = {},
        onAddClick = viewModel::onAddClick,
        onRemoveClick = viewModel::onRemoveClick,
        onAddToCartClick = viewModel::onAddToCartClick,
        onBuyNowClick = viewModel::onBuyNowClick
    )
}