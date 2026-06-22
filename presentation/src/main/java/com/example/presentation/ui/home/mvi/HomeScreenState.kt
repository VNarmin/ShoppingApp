package com.example.presentation.ui.home.mvi

import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.ui.home.widget.CategoryFilterState

internal data class HomeScreenState(
    val username: String = "",
    val searchQuery: String = "",
    val categoryFilterState: CategoryFilterState = CategoryFilterState(
        categories = emptyList(),
        selectedCategory = Category(
            categoryID = "",
            displayName = "",
            itemCount = 0
        )
    ),
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = HomeScreenState()
    }
}