package com.example.presentation.ui.categoryDetail.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CategoryDetailViewModel(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : ViewModel(), ContainerHost<CategoryDetailScreenState, CategoryDetailEffect> {
    override val container = container<CategoryDetailScreenState, CategoryDetailEffect>(
        initialState = CategoryDetailScreenState.INITIAL
    )

    // both data sources are needed simultaneously to render the screen
    // without wrapping in an intent block = concurrently
    fun loadScreen(categoryID: String) {
        intent { reduce { state.copy(loading = true, errorMessage = null) } }
        getCategoryDetails(categoryID = categoryID)
        getProductsByCategory(categoryID = categoryID)
    }

    private fun getCategoryDetails(categoryID: String) = intent {
        categoryRepository.getCategoryDetails(categoryID)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CategoryDetailEffect.Error(errorMessage = message))
            }
            .collect { category ->
                reduce {
                    state.copy(
                        loading = false,
                        currentCategory = category
                    )
                }
            }
    }

    private fun getProductsByCategory(categoryID: String) = intent {
        productRepository.getProductsByCategory(categoryID)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CategoryDetailEffect.Error(errorMessage = message))
            }
            .collect { products ->
                reduce {
                    state.copy(
                        loading = false,
                        products = products
                    )
                }
            }
    }

    fun onProductClick(productID : String) = intent {
        postSideEffect(CategoryDetailEffect.NavigateToProductDetail(productID = productID))
    }

    fun onHomeClick() = intent {
        postSideEffect(CategoryDetailEffect.NavigateToHome)
    }

    fun onBackClick() = intent {
        postSideEffect(CategoryDetailEffect.NavigateToMore)
    }
}