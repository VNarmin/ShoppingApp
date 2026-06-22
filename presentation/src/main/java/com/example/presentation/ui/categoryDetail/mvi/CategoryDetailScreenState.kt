package com.example.presentation.ui.categoryDetail.mvi

import com.example.domain.model.Category
import com.example.domain.model.Product

internal data class CategoryDetailScreenState(
    val currentCategory : Category = Category(
        categoryID = "",
        displayName = "",
        itemCount = 0
    ),
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = CategoryDetailScreenState()
    }
}