package com.example.data.dto

data class ProductDTO(
    val productID: String?,
    val name: String?,
    val description: String?,
    val price: Double?,
    val images: List<String?>?,
    val category: CategoryDTO?,
    val stockCount: Int?,
    val rating: Double?,
    val reviewCount: Int?
)