package com.example.presentation.ui.home.mvi

import com.example.domain.model.Category
import com.example.domain.model.Product

internal data class HomeScreenState(
    val username: String = "Narmin",
    val searchQuery: String = "",
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category,
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
)