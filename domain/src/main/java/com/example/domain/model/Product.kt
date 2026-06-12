package com.example.domain.model

data class Product(
    val productID: String,
    val name: String,
    val description: String,
    val price: Double,
    val images: List<String>,
    val category: Category?,
    val stockCount: Int,
    val rating: Double,
    val reviewCount: Int
) {
    val inStock: Boolean get() = stockCount > 0
}