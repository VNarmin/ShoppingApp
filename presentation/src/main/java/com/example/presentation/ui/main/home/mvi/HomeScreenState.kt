package com.example.presentation.ui.main.home.mvi

import com.example.domain.model.Product
import com.example.presentation.ui.main.home.widget.CategoryFilterState

internal data class HomeScreenState(
    val username: String = "",
    val searchQuery: String = "",
    val categoryFilterState: CategoryFilterState = CategoryFilterState(
        categories = emptyList(),
        selectedCategoryID = ""
    ),
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = HomeScreenState()
    }
}