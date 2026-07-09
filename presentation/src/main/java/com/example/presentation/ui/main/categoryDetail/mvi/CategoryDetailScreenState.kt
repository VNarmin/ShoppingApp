package com.example.presentation.ui.main.categoryDetail.mvi

import androidx.compose.runtime.Immutable
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.ui.common.ProductState
import com.example.presentation.ui.main.categoryDetail.widget.CategoryDetailBodyState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class CategoryDetailScreenState(
    val currentCategory: Category = Category(
        categoryID = "",
        displayName = "",
        itemCount = 0
    ),
    val products: ImmutableList<Product> = persistentListOf(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    fun formCategoryDetailBodyState(): CategoryDetailBodyState = CategoryDetailBodyState(
        itemCount = products.size,
        productStates = formProductCardStates()
    )

    private fun formProductCardStates(): ImmutableList<ProductState> =
        products.map { product ->
            ProductState(
                productID = product.productID,
                productName = product.name,
                productPrice = product.price,
                productImages = product.images
            )
        }.toImmutableList()

    companion object {
        val INITIAL = CategoryDetailScreenState()
    }
}