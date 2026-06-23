package com.example.domain.repository

import com.example.domain.model.Category
import com.example.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>

    fun getProductsByCategory(categoryID: String): Flow<List<Product>>

    fun searchProducts(searchQuery: String): Flow<List<Product>>

    fun getProductDetails(productID: String): Flow<Product>
}