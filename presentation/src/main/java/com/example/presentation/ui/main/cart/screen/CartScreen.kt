package com.example.presentation.ui.main.cart.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.main.cart.mvi.CartEffect
import com.example.presentation.ui.main.cart.mvi.CartViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CartScreen(
    viewModel: CartViewModel = koinViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToCheckout: () -> Unit
) {
    val cartScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is CartEffect.NavigateBack -> onNavigateBack()
            is CartEffect.NavigateToCheckout -> onNavigateToCheckout()
            is CartEffect.Error -> {}
        }
    }

    CartScreenContent(
        stateProvider = { cartScreenState },
        onBackClick = viewModel::onBackClick,
        onDeleteClick = viewModel::onDeleteClick,
        onAddClick = viewModel::onAddClick,
        onRemoveClick = viewModel::onRemoveClick,
        onProceedToCheckOutClick = viewModel::onProceedToCheckoutClick
    )
}