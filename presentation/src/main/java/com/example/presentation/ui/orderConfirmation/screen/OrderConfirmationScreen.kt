package com.example.presentation.ui.orderConfirmation.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.orderConfirmation.mvi.OrderConfirmationEffect
import com.example.presentation.ui.orderConfirmation.mvi.OrderConfirmationViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun OrderConfirmationScreen(
    viewModel: OrderConfirmationViewModel = koinViewModel(),
    onNavigateToHome: () -> Unit
) {
    val orderConfirmationScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is OrderConfirmationEffect.NavigateToHome -> onNavigateToHome()
            is OrderConfirmationEffect.Error -> {}
        }
    }
}