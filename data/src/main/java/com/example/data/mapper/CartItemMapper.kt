package com.example.data.mapper

import com.example.data.local.entity.CartItemEntity
import com.example.domain.model.CartItem
import com.example.domain.model.Product

internal fun CartItemEntity.toDomain() : CartItem = CartItem(
    product = Product(
        productID = this.productID,
        name = this.name,
        price = this.price,
        images = listOf(this.image),
        description = "",
        category = null,
        stockCount = this.stockCount,
        rating = 0.0,
        reviewCount = 0
    ),
    quantity = this.quantity
)

internal fun List<CartItemEntity>.toDomain(): List<CartItem> = map { cartItemEntity ->
    cartItemEntity.toDomain()
}

internal fun CartItem.toEntity() : CartItemEntity = CartItemEntity(
    productID = this.product.productID,
    name = this.product.name,
    price = this.product.price,
    image = this.product.images.firstOrNull() ?: "",
    stockCount = this.product.stockCount,
    quantity = this.quantity
)