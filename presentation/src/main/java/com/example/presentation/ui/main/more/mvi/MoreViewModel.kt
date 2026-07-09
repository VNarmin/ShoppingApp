package com.example.presentation.ui.main.more.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CategoryRepository
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class MoreViewModel(
    private val authRepository: AuthRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel(), ContainerHost<MoreScreenState, MoreEffect> {

    override val container = container<MoreScreenState, MoreEffect>(
        initialState = MoreScreenState.INITIAL
    )

    init { loadScreen() }

    private fun loadScreen() {
        intent { reduce { state.copy(loading = true, errorMessage = null) } }
        getCurrentUser()
        getCategories()
    }

    private fun getCurrentUser() = intent {
        authRepository.getCurrentUser()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(MoreEffect.Error(errorMessage = message))
            }
            .collect { user ->
                reduce {
                    state.copy(
                        loading = false,
                        username = user?.username ?: "",
                    )
                }
            }
    }

    private fun getCategories() = intent {
        categoryRepository.getCategories()
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(MoreEffect.Error(errorMessage = message))
            }
            .collect { categories ->
                reduce {
                    state.copy(
                        loading = false,
                        categories = categories.toImmutableList()
                    )
                }
            }
    }

    fun onHomeClick() = intent {
        postSideEffect(MoreEffect.NavigateToHome)
    }

    fun onCategoryClick(categoryID: String) = intent {
        postSideEffect(MoreEffect.NavigateToCategoryDetail(categoryID = categoryID))
    }
}