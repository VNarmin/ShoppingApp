package com.example.presentation.ui.main.home.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.collections.immutable.toImmutableList
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import kotlin.time.Duration.Companion.milliseconds

internal class HomeViewModel(
    private val authRepository: AuthRepository,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : ViewModel(), ContainerHost<HomeScreenState, HomeEffect> {

    companion object {
        private const val DEFAULT_CATEGORY_ID = "all"
    }

    override val container = container<HomeScreenState, HomeEffect>(
        initialState = HomeScreenState.INITIAL
    )

    init { loadScreen() }

    private fun loadScreen() {
        intent { reduce { state.copy(loading = true, errorMessage = null) } }
        getCurrentUser()
        getCategories()
        observeSearchQuery()
    }

    private fun getCurrentUser() = intent {
        authRepository.getCurrentUser()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(errorMessage = message))
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

    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() = intent {
        container.stateFlow
            .map { state -> state.searchQuery }
            .drop(count = 1) // skips the first emission entirely
            .debounce(timeout = 500.milliseconds) // the user types fast, we do not want to fire a search on every single keystroke
            .distinctUntilChanged() // prevents firing the same search multiple times if the search query has not actually changed
            .collect { searchQuery ->
                if (searchQuery.isEmpty()) {
                    onCategoryChange(categoryID = DEFAULT_CATEGORY_ID)
                } else {
                    searchProducts(searchQuery)
                }
            }
    }

    private fun searchProducts(searchQuery: String) = intent {
        reduce { state.copy(loading = true) }
        productRepository.searchProducts(searchQuery = searchQuery)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(errorMessage = message))
            }
            .collect { products ->
                reduce { state.copy(loading = false, products = products.toImmutableList()) }
            }
    }

    // called in two situations — from getCategories() on launch,
    // and from the UI when the user taps a category tab
    private fun getCategories() = intent {
        categoryRepository.getCategories()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(errorMessage = message))
            }
            .collect { categories ->
                reduce {
                    state.copy(
                        loading = false,
                        categories = categories.toImmutableList(),
                        selectedCategoryID = DEFAULT_CATEGORY_ID
                    )
                }
                onCategoryChange(categoryID = DEFAULT_CATEGORY_ID)
            }
    }

    fun onCategoryChange(categoryID: String) = intent {
        reduce {
            state.copy(
                loading = true,
                selectedCategoryID = categoryID
            )
        }
        productRepository.getProductsByCategory(categoryID = categoryID)
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(HomeEffect.Error(errorMessage = message))
            }
            .collect { products ->
                reduce {
                    state.copy(
                        loading = false,
                        products = products.toImmutableList()
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