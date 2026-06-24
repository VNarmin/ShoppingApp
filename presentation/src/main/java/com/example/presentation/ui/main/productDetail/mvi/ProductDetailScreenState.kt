package com.example.presentation.ui.main.productDetail.mvi

import com.example.domain.model.Category
import com.example.domain.model.Product

internal data class ProductDetailScreenState(
    val product: Product = Product(
        productID = "",
        name = "",
        description = "",
        price = 0.0,
        images = emptyList(),
        category = Category(
            categoryID = "",
            displayName = "",
            itemCount = 0
        ),
        stockCount = 0,
        rating = 0.0,
        reviewCount = 0
    ),
    val quantity: Int = 0,
    val descriptionExpanded: Boolean = false,
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = ProductDetailScreenState()
    }
}