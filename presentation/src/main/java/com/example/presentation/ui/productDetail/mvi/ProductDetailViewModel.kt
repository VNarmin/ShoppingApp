package com.example.presentation.ui.productDetail.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class ProductDetailViewModel(
    private val productRepository: ProductRepository
) : ViewModel(), ContainerHost<ProductDetailScreenState, ProductDetailEffect> {
    override val container = container<ProductDetailScreenState, ProductDetailEffect>(initialState = ProductDetailScreenState.INITIAL)

    fun onBackClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateBack)
    }

    fun getProductDetails(productID: String) = intent {
        reduce { state.copy(loading = true) }
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

    fun onCartClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCart) // without adding
    }

    fun onAddToCartClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCart) // by adding
    }

    fun onBuyNowClick() = intent {
        postSideEffect(ProductDetailEffect.NavigateToCheckout)
    }

    fun onAddClick() = intent { // for the quantity selector

    }

    fun onRemoveClick() = intent { // for the quantity selector

    }
}
