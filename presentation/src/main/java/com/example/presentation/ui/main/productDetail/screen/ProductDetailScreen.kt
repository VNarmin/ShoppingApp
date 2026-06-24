package com.example.presentation.ui.main.productDetail.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.presentation.ui.main.productDetail.mvi.ProductDetailEffect
import com.example.presentation.ui.main.productDetail.mvi.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun ProductDetailScreen(
    productID: String,
    viewModel: ProductDetailViewModel = koinViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToCart: () -> Unit,
    onNavigateToCheckout: () -> Unit
) {
    val state = viewModel.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.getProductDetails(productID = productID)
    }

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is ProductDetailEffect.NavigateBack -> onNavigateBack()
            is ProductDetailEffect.NavigateToCart -> onNavigateToCart()
            is ProductDetailEffect.NavigateToCheckout -> onNavigateToCheckout()
            is ProductDetailEffect.Error -> {}
        }
    }

    ProductDetailScreenContent(
        stateProvider = { state },
        onBackClick = viewModel::onBackClick,
        onCartClick = viewModel::onCartClick,
        onReadMoreClick = viewModel::onReadMoreClick,
        onAddClick = viewModel::onAddClick,
        onRemoveClick = viewModel::onRemoveClick,
        onAddToCartClick = viewModel::onAddToCartClick,
        onBuyNowClick = viewModel::onBuyNowClick
    )
}