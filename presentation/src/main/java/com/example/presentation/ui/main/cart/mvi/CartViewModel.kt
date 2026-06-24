package com.example.presentation.ui.main.cart.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.CartRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CartViewModel(
    private val cartRepository: CartRepository
) : ViewModel(), ContainerHost<CartScreenState, CartEffect> {

    override val container = container<CartScreenState, CartEffect>(
        initialState = CartScreenState.INITIAL
    )

    init { getCartItems() }

    private fun getCartItems() = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        cartRepository.getCartItems()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CartEffect.Error(errorMessage = message))
            }
            .collect { cartItems ->
                val totalItemCount = cartItems.sumOf {cartItem -> cartItem.quantity}
                val subtotal = cartItems.sumOf { cartItem -> cartItem.totalPrice }
                val shippingCost = if (cartItems.isEmpty()) 0.0 else 5.0
                val total = subtotal + shippingCost
                reduce {
                    state.copy(
                        loading = false,
                        cartItems = cartItems,
                        totalItemCount = totalItemCount,
                        cartSummaryState = state.cartSummaryState.copy(
                            subtotal = subtotal,
                            shippingCost = shippingCost,
                            total = total
                        )
                    )
                }
            }
    }

    fun onDeleteClick(productID: String) = intent {
        try {
            cartRepository.removeFromCart(productID = productID)
        }
        catch (error: Exception) {
            val message = error.message ?: "Something went wrong."
            reduce { state.copy(errorMessage = message) }
            postSideEffect(CartEffect.Error(errorMessage = message))
        }
    }

    fun onBackClick() = intent {
        postSideEffect(CartEffect.NavigateBack)
    }

    fun onProceedToCheckoutClick() = intent {
        postSideEffect(CartEffect.NavigateToCheckout)
    }

    fun onAddClick(productID: String) = intent {
        val cartItem = state.cartItems.find { cartItem ->
            cartItem.product.productID == productID
        } ?: return@intent

        updateQuantity(
            productID = productID,
            quantity = cartItem.quantity + 1
        )
    }

    fun onRemoveClick(productID: String) = intent {
        val cartItem = state.cartItems.find { cartItem ->
            cartItem.product.productID == productID
        } ?: return@intent

        updateQuantity(
            productID = productID,
            quantity = cartItem.quantity - 1
        )
    }

    private fun updateQuantity(productID: String, quantity: Int) = intent {
        try {
            cartRepository.updateQuantity(
                productID = productID,
                quantity = quantity
            )
        }
        catch(error: Exception) {
            val message = error.message ?: "Something went wrong."
            reduce { state.copy(errorMessage = message) }
            postSideEffect(CartEffect.Error(errorMessage = message))
        }
    }
}