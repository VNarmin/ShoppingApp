package com.example.data.repository

import com.example.domain.model.User
import com.example.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun authenticate(
        emailAddress: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun register(
        username: String,
        emailAddress: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(emailAddress: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Result<Unit> {
        TODO("Not yet implemented")
    }

}