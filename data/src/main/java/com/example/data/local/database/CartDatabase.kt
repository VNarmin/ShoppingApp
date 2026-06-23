package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CartDao
import com.example.data.local.entity.CartItemEntity

@Database(
    entities = [CartItemEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class CartDatabase : RoomDatabase() {
    abstract fun getCartDao(): CartDao
}