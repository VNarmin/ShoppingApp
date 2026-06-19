package com.example.data.repository

import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.domain.repository.ProductRepository

internal class ProductRepositoryImpl : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun filterProductsByCategory(category: Category): Result<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun searchProducts(query: String): Result<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductDetails(productID: String): Result<Product> {
        TODO("Not yet implemented")
    }

}