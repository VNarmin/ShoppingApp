package com.example.data.mapper

import com.example.data.dto.ProductDTO
import com.example.domain.model.Product

fun ProductDTO.toDomain(): Product? {
    return Product(
        productID = this.productID ?: return null,
        name = this.name ?: return null,
        description = this.description.orEmpty(),
        price = this.price ?: return null,
        images = this.images?.filterNotNull().orEmpty(),
        category = this.category?.toDomain() ?: return null,
        stockCount = this.stockCount ?: return null,
        rating = this.rating ?: 0.0,
        reviewCount = this.reviewCount ?: 0
    )
}

fun List<ProductDTO>.toDomain(): List<Product> = mapNotNull { product -> product.toDomain() }