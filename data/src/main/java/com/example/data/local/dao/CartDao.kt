package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CartDao {
    @Query("SELECT * FROM cart_items")
    fun getCartItems(): Flow<List<CartItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItemEntity: CartItemEntity)

    @Query("DELETE FROM cart_items WHERE productID = :productID")
    suspend fun removeCartItem(productID: String)

    @Query("UPDATE cart_items SET quantity = :quantity WHERE productID = :productID")
    suspend fun updateQuantity(productID: String, quantity: Int)

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
}