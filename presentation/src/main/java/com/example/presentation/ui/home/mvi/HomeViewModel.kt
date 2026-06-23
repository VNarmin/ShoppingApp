package com.example.presentation.ui.home.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.LoadHomeScreenUseCase
import com.example.presentation.ui.home.widget.CategoryFilterState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class HomeViewModel(
    private val loadHomeScreenUseCase: LoadHomeScreenUseCase
) : ViewModel(), ContainerHost<HomeScreenState, HomeEffect> {
    override val container = container<HomeScreenState, HomeEffect>(initialState = HomeScreenState.INITIAL)

    fun loadScreen() = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        combine(
            flow = loadHomeScreenUseCase.getCurrentUser(),
            flow2 = loadHomeScreenUseCase.getCategories()
        ) { user, categories -> user to categories }
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(message))
            }
            .collect { (user, categories) ->
                val firstCategory = categories.firstOrNull()
                reduce {
                    state.copy(
                        loading = false,
                        username = user?.username ?: "",
                        categoryFilterState = CategoryFilterState(
                            categories = categories,
                            selectedCategoryID = firstCategory?.categoryID ?: ""
                        )
                    )
                }
                firstCategory?.let { onCategoryChange(it.categoryID) }
            }
    }

    fun onCategoryChange(categoryID: String) = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        loadHomeScreenUseCase.getProductsByCategory(categoryID = categoryID)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(message))
            }
            .collect { products ->
                reduce {
                    state.copy(
                        loading = false,
                        products = products,
                        categoryFilterState = state.categoryFilterState.copy(
                            selectedCategoryID = categoryID
                        )
                    )
                }
            }
    }

    fun onCartClick() = intent {
        postSideEffect(HomeEffect.NavigateToCart)
    }

    fun onSearchQueryChange(searchQuery: String) = intent {
        reduce { state.copy(searchQuery = searchQuery) }
    }

    fun onProductClick(productID: String) = intent {
        postSideEffect(HomeEffect.NavigateToProductDetail(productID = productID))
    }

    fun onMoreClick() = intent {
        postSideEffect(HomeEffect.NavigateToMore)
    }
}