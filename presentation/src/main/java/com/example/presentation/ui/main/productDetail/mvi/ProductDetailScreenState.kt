package com.example.presentation.ui.main.productDetail.mvi

import androidx.compose.runtime.Immutable
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.ui.common.QuantitySelectorState
import com.example.presentation.ui.main.productDetail.widget.ProductDetailBodyState
import com.example.presentation.ui.main.productDetail.widget.ProductImagePagerState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class ProductDetailScreenState(
    val product: Product = Product(
        productID = "",
        name = "",
        description = "",
        price = 0.0,
        images = persistentListOf(),
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
    val canPurchase: Boolean
        get() = product.inStock && quantity > 0

    fun formProductDetailBodyState(): ProductDetailBodyState = ProductDetailBodyState(
        product = product,
        productImagePagerState = formProductImagePagerState(),
        quantitySelectorState = formQuantitySelectorState(),
        descriptionExpanded = descriptionExpanded
    )

    private fun formProductImagePagerState(): ProductImagePagerState = ProductImagePagerState(
        productImages = product.images.toImmutableList()
    )

    private fun formQuantitySelectorState(): QuantitySelectorState = QuantitySelectorState(
        quantity = quantity,
        stockCount = product.stockCount
    )

    companion object {
        val INITIAL = ProductDetailScreenState()
    }
}