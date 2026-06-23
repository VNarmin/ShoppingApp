package com.example.presentation.ui.checkout.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.presentation.ui.checkout.mvi.CheckoutEffect
import com.example.presentation.ui.checkout.mvi.CheckoutViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CheckoutScreen(
    viewModel: CheckoutViewModel = koinViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToOrderConfirmation: () -> Unit
) {
    val checkoutScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when(effect) {
            is CheckoutEffect.NavigateBack -> onNavigateBack()
            is CheckoutEffect.NavigateToOrderConfirmation -> onNavigateToOrderConfirmation()
            is CheckoutEffect.Error -> {}
        }
    }

    CheckoutScreenContent(
        stateProvider = { checkoutScreenState },
        onBackClick = viewModel::onBackClick,
        onPlaceOrderClick = viewModel::onPlaceOrderClick
    )
}