package com.example.domain.repository

import com.example.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun addToCart(cartItem: CartItem)
    suspend fun removeFromCart(productID: String)
    suspend fun updateQuantity(productID: String, quantity: Int)
    suspend fun clearCart()
}