package com.example.data.mapper

import com.example.data.dto.ProductDTO
import com.example.domain.model.Product

fun ProductDTO.toDomain(): Product {
    return Product(
        productID = this.productID.orEmpty(),
        name = this.name.orEmpty(),
        description = this.description.orEmpty(),
        price = this.price ?: 0.0,
        images = this.images?.filterNotNull().orEmpty(),
        category = this.category?.toDomain(),
        stockCount = this.stockCount ?: 0,
        rating = this.rating ?: 0.0,
        reviewCount = this.reviewCount ?: 0
    )
}

fun List<ProductDTO>.toDomain(): List<Product> = mapNotNull { product -> product.toDomain() }