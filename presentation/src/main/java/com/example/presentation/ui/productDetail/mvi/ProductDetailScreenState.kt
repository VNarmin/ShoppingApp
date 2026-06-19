package com.example.presentation.ui.productDetail.mvi

import com.example.domain.model.Product

internal data class ProductDetailScreenState(
    val product: Product,
    val quantity: Int = 1,
    val descriptionExpanded: Boolean = false,
    val loading: Boolean = false,
    val errorMessage: String? = null
)