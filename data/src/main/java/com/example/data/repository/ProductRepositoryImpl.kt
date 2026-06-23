package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.mock.MockProducts
import com.example.domain.model.Product
import com.example.domain.repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

internal class ProductRepositoryImpl : ProductRepository {

    override fun getProducts(): Flow<List<Product>> = flow {
        delay(duration = 500.milliseconds)
        val products = MockProducts.all.toDomain()
        emit(products)
    }

    override fun getProductsByCategory(categoryID: String): Flow<List<Product>> = flow {
        delay(duration = 500.milliseconds)
        val filteredProducts = if (categoryID == "all") {
            MockProducts.all
        } else {
            MockProducts.all.filter { product ->
                product.category?.categoryID == categoryID
            }
        }.toDomain()
        emit(filteredProducts)
    }

    override fun searchProducts(searchQuery: String): Flow<List<Product>> = flow {
        delay(duration = 500.milliseconds)
        val searchResults = MockProducts.all.filter { product ->
            product.name?.contains(other = searchQuery, ignoreCase = true) == true ||
                    product.description?.contains(other = searchQuery, ignoreCase = true) == true
        }.toDomain()
        emit(searchResults)
    }

    override fun getProductDetails(productID: String): Flow<Product> = flow {
        delay(duration = 500.milliseconds)
        val product = MockProducts.all.find { product ->
            product.productID == productID
        }?.toDomain() ?: throw NoSuchElementException("Product Not Found")
        emit(product)
    }
}