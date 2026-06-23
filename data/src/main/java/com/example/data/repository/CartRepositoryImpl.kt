package com.example.data.repository

import com.example.data.local.dao.CartDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.CartItem
import com.example.domain.repository.CartRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class CartRepositoryImpl(
    private val cartDao: CartDao,
    private val dispatcher: CoroutineDispatcher
) : CartRepository {

    override fun getCartItems(): Flow<List<CartItem>> =
        cartDao.getCartItems()
            .map { cartItemEntities -> cartItemEntities.toDomain() }
            .flowOn(context = dispatcher)

    override suspend fun addToCart(cartItem: CartItem) =
        withContext(dispatcher) {
            cartDao.insertCartItem(cartItemEntity = cartItem.toEntity())
        }

    override suspend fun removeFromCart(productID: String) =
        withContext(dispatcher) {
            cartDao.removeCartItem(productID = productID)
        }

    override suspend fun updateQuantity(productID: String, quantity: Int) =
        withContext(dispatcher) {
            cartDao.updateQuantity(productID = productID, quantity = quantity)
        }

    override suspend fun clearCart() = withContext(dispatcher) {
        cartDao.clearCart()
    }
}