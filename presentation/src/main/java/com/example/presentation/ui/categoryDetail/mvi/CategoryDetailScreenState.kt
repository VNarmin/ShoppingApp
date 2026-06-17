package com.example.presentation.ui.categoryDetail.mvi

import com.example.domain.model.Category
import com.example.domain.model.Product

data class CategoryDetailScreenState(
    val currentCategory : Category,
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
)