package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
internal data class CartItemEntity(
    @PrimaryKey val productID: String,
    val name: String,
    val price: Double,
    val image: String,
    val stockCount: Int,
    val quantity: Int
)