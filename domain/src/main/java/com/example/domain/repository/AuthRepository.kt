package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<User>

    fun register(username: String, email: String, password: String): Flow<User>

    suspend fun logout()

    suspend fun resetPassword(email: String)

    fun getCurrentUser(): User?

    fun shouldSkipAuth(): Boolean

    fun setRememberMe(flagRememberMe: Boolean)

    fun getRememberMe(): Boolean
}