package com.example.presentation.ui.more.mvi

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.LoadMoreScreenUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class MoreViewModel(
    private val loadMoreScreenUseCase: LoadMoreScreenUseCase
) : ViewModel(), ContainerHost<MoreScreenState, MoreEffect> {
    override val container = container<MoreScreenState, MoreEffect>(initialState = MoreScreenState.INITIAL)

    fun loadScreen() = intent {
        reduce { state.copy(loading = true, errorMessage = null) }
        combine(
            flow = loadMoreScreenUseCase.getCurrentUser(),
            flow2 = loadMoreScreenUseCase.getCategories()
        ) { user, categories -> user to categories }
            .catch { error ->
                val message = error.message ?: "Something went wrong."
                reduce { state.copy(loading = false, errorMessage = message) }
                postSideEffect(MoreEffect.Error(message))
            }
            .collect { (user, categories) ->
                reduce {
                    state.copy(
                        loading = false,
                        username = user?.username ?: "",
                        categories = categories
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