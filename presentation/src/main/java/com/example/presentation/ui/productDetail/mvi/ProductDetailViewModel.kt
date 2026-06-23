package com.example.presentation.ui.productDetail.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class ProductDetailViewModel(
    private val productRepository: ProductRepository
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
                reduce { state.copy(loading = false, product = product) }
            }
    }

    fun onBackClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateBack)
    }

    fun onCartClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCart) // without adding
    }

    fun onAddToCartClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCart) // by adding
    }

    fun onBuyNowClick() = intent {
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
        if (state.quantity > 0) {
            reduce { state.copy(quantity = state.quantity - 1) }
        }
    }
}
