package com.example.presentation.ui.checkout.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CartRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CheckoutViewModel(
    private val authRepository: AuthRepository,
    private val cartRepository: CartRepository
) : ViewModel(), ContainerHost<CheckoutScreenState, CheckoutEffect> {

    override val container = container<CheckoutScreenState, CheckoutEffect>(
        initialState = CheckoutScreenState.INITIAL
    )

    init { loadScreen() }

    private fun loadScreen() {
        intent { reduce { state.copy(loading = true, errorMessage = null) } }
        getCurrentUser()
        getOrderSummary()
    }

    private fun getCurrentUser() = intent {
        authRepository.getCurrentUser()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CheckoutEffect.Error(errorMessage = message))
            }
            .collect { user ->
                reduce {
                    state.copy(
                        loading = false,
                        username = user?.username ?: ""
                    )
                }
            }
    }

    private fun getOrderSummary() = intent {
        cartRepository.getCartItems()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CheckoutEffect.Error(errorMessage = message))
            }
            .collect { cartItems ->
                val totalItemCount = cartItems.sumOf {cartItem -> cartItem.quantity}
                val subtotal = cartItems.sumOf { cartItem -> cartItem.totalPrice }
                val shippingCost = if (cartItems.isEmpty()) 0.0 else 5.0
                val total = subtotal + shippingCost

                reduce {
                    state.copy(
                        loading = false,
                        orderSummaryState = state.orderSummaryState.copy(
                            totalItemCount = totalItemCount,
                            subtotal = subtotal,
                            shippingCost = shippingCost,
                            total = total
                        )
                    )
                }
            }
    }

    fun onBackClick() = intent {
        postSideEffect(CheckoutEffect.NavigateBack)
    }

    fun onPlaceOrderClick() = intent {
        postSideEffect(CheckoutEffect.NavigateToOrderConfirmation)
    }
}