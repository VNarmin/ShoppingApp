package com.example.domain.usecase

import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.ProductRepository

class LoadHomeScreenUseCase(
    private val authRepository: AuthRepository,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) {
    fun getCurrentUser() = authRepository.getCurrentUser()

    fun searchProducts(searchQuery: String) =
        productRepository.searchProducts(searchQuery = searchQuery)

    fun getCategories() = categoryRepository.getCategories()

    fun getProductsByCategory(categoryID: String) =
        productRepository.getProductsByCategory(categoryID = categoryID)
}