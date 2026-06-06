package com.example.domain.repository

import com.example.domain.model.Category
import com.example.domain.model.Product

interface ProductRepository {

    suspend fun getProducts() : Result<List<Product>>

    suspend fun filterProductsByCategory(category: Category) : Result<List<Product>>

    suspend fun searchProducts(query: String) : Result<List<Product>>

    suspend fun getProductDetails(productID: String) : Result<Product>
}