package com.example.presentation.ui.main.productDetail.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.model.CartItem
import com.example.domain.repository.CartRepository
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class ProductDetailViewModel(
    private val productRepository: ProductRepository,
    private val cartRepository: CartRepository
) : ViewModel(), ContainerHost<ProductDetailScreenState, ProductDetailEffect> {

    override val container = container<ProductDetailScreenState, ProductDetailEffect>(
        initialState = ProductDetailScreenState.INITIAL
    )

    fun getProductDetails(productID: String) = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        productRepository.getProductDetails(productID = productID)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(ProductDetailEffect.Error(errorMessage = message))
            }
            .collect { product ->
                reduce {
                    state.copy(
                        loading = false,
                        product = product,
                        quantity = if (product.inStock) 1 else 0,
                        canPurchase = product.inStock
                    )
                }
            }
    }

    fun onBackClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateBack)
    }

    fun onCartClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCart) // without adding
    }

    fun onAddToCartClick() = intent { // by adding
        val product = state.product
        val quantity = state.quantity
        val cartItem = CartItem(product = product, quantity = quantity)

        cartRepository.addToCart(cartItem = cartItem)
        postSideEffect(ProductDetailEffect.NavigateToCart)
    }

    fun onBuyNowClick() = intent {
        val product = state.product
        val quantity = state.quantity
        val cartItem = CartItem(product = product, quantity = quantity)

        cartRepository.addToCart(cartItem = cartItem)
        postSideEffect(ProductDetailEffect.NavigateToCheckout)
    }

    fun onReadMoreClick() = intent {
        reduce { state.copy(descriptionExpanded = !state.descriptionExpanded) }
    }

    fun onAddClick() = intent {
        if (state.quantity < state.product.stockCount) {
            reduce { state.copy(quantity = state.quantity + 1) }
        }
    }

    fun onRemoveClick() = intent {
        if (state.quantity > 1) {
            reduce { state.copy(quantity = state.quantity - 1) }
        }
    }
}