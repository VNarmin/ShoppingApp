package com.example.presentation.ui.categoryDetail.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.LoadCategoryDetailScreenUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CategoryDetailViewModel(
    private val loadCategoryDetailScreenUseCase: LoadCategoryDetailScreenUseCase
) : ViewModel(), ContainerHost<CategoryDetailScreenState, CategoryDetailEffect> {
    override val container = container<CategoryDetailScreenState, CategoryDetailEffect>(initialState = CategoryDetailScreenState.INITIAL)

    fun loadScreen(categoryID: String) = intent { // an ID should come from the previous screen
        reduce { state.copy(loading = true, errorMessage = null) }
        combine(
            flow = loadCategoryDetailScreenUseCase.getCategoryDetails(categoryID),
            flow2 = loadCategoryDetailScreenUseCase.getProductsByCategory(categoryID)
        ) { currentCategory, products -> currentCategory to products }
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(CategoryDetailEffect.Error(message))
            }
            .collect { (currentCategory, products) ->
                reduce {
                    state.copy(
                        loading = false,
                        currentCategory = currentCategory,
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