package com.example.domain.usecase

import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.ProductRepository

class LoadCategoryDetailScreenUseCase(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) {
    fun getCategoryDetails(categoryID: String) =
        categoryRepository.getCategoryDetails(categoryID = categoryID)

    fun getProductsByCategory(categoryID: String) =
        productRepository.getProductsByCategory(categoryID = categoryID)
}