package com.example.presentation.ui.main.home.mvi

import androidx.compose.runtime.Immutable
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.ui.common.ProductState
import com.example.presentation.ui.main.home.widget.CategoryFilterState
import com.example.presentation.ui.main.home.widget.CategoryState
import com.example.presentation.ui.main.home.widget.HomeBodyState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class HomeScreenState(
    val username: String = "",
    val searchQuery: String = "",
    val categories: ImmutableList<Category> = persistentListOf(),
    val selectedCategoryID: String = "",
    val products: ImmutableList<Product> = persistentListOf(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    fun formHomeBodyState(): HomeBodyState = HomeBodyState(
        searchQuery = searchQuery,
        categoryFilterState = formCategoryFilterState(),
        productStates = formProductStates()
    )

    private fun formCategoryFilterState(): CategoryFilterState = CategoryFilterState(
        categoryStates = formCategoryStates(),
        selectedCategoryID = selectedCategoryID
    )

    private fun formCategoryStates(): ImmutableList<CategoryState> =
        categories.map { category ->
            CategoryState(
                categoryID = category.categoryID,
                categoryLabel = category.displayName,
                categorySelected = category.categoryID == selectedCategoryID,
            )
        }.toImmutableList()

    private fun formProductStates(): ImmutableList<ProductState> =
        products.map { product ->
            ProductState(
                productID = product.productID,
                productName = product.name,
                productPrice = product.price,
                productImages = product.images
            )
        }.toImmutableList()

    companion object {
        val INITIAL = HomeScreenState()
    }
}