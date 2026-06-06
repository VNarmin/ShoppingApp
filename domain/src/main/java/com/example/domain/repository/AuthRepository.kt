package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(emailAddress: String, password: String): Flow<User>

    fun register(username: String, emailAddress: String, password: String): Flow<User>

    suspend fun logout()

    suspend fun resetPassword(emailAddress: String)

    fun getCurrentUser(): User?

    fun shouldSkipAuth(): Boolean

    fun setRememberMe(flagRememberMe: Boolean)

    fun getRememberMe(): Boolean
}