package com.example.domain.repository

import com.example.domain.model.User

interface AuthRepository {

    suspend fun authenticate(emailAddress: String, password: String) : Result<User>

    suspend fun register(username: String,
                         emailAddress: String,
                         password: String) : Result<User>

    suspend fun resetPassword(emailAddress : String) : Result<Unit>

    suspend fun logout() : Result<Unit>
}