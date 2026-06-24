package com.example.presentation.ui.main.orderConfirmation.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.CartRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class OrderConfirmationViewModel(
    private val cartRepository: CartRepository
) : ViewModel(), ContainerHost<OrderConfirmationScreenState, OrderConfirmationEffect> {

    override val container = container<OrderConfirmationScreenState, OrderConfirmationEffect>(
        initialState = OrderConfirmationScreenState.INITIAL
    )

    init { clearCart() }

    private fun clearCart() = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        try {
            cartRepository.clearCart()
            reduce { state.copy(loading = false) }
        } catch (error: Exception) {
            val message = error.message ?: "Something went wrong."
            reduce { state.copy(loading = false, errorMessage = message) }
            postSideEffect(OrderConfirmationEffect.Error(errorMessage = message))
        }
    }

    fun onContinueShoppingClick() = intent {
        postSideEffect(OrderConfirmationEffect.NavigateToHome)
    }
}