package com.example.data.repository

import android.content.SharedPreferences
import com.example.domain.model.User
import com.example.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import androidx.core.content.edit
import com.example.data.mapper.toDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class AuthRepositoryImpl(
    private val auth: FirebaseAuth,
    private val sp: SharedPreferences,
    private val dispatcher: CoroutineDispatcher
) : AuthRepository {

    override fun login(
        email: String,
        password: String
    ): Flow<User> = flow {
        val response = auth
            .signInWithEmailAndPassword(email, password)
            .await()

        // FirebaseUser
        val currentUser = response.user?.toDomain() ?: throw Exception("Failed Authentication")

        emit(currentUser)
    }.flowOn(context = dispatcher)

    override fun register(
        username: String,
        email: String,
        password: String
    ): Flow<User> = flow {
        val response = auth
            .createUserWithEmailAndPassword(email, password)
            .await()

        val currentUser = response.user ?: throw Exception("Failed Registration")

        val profileUpdates = UserProfileChangeRequest
            .Builder()
            .setDisplayName(username)
            .build()

        // FirebaseUser
        currentUser.updateProfile(profileUpdates).await()

        emit(User(
            userID = currentUser.uid,
            username = username,
            emailAddress = email
        ))
    }.flowOn(context = dispatcher)

    override suspend fun logout() = withContext(dispatcher) {
        auth.signOut()
        setRememberMe(flagRememberMe = false)
    }

    override suspend fun resetPassword(email: String) = withContext(dispatcher) {
        auth.sendPasswordResetEmail(email).await()
        Unit
    }

    override fun getCurrentUser(): Flow<User?> = callbackFlow {
        val listener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser?.toDomain())
        }
        auth.addAuthStateListener(listener)
        awaitClose { auth.removeAuthStateListener(listener) }
    }.flowOn(context = dispatcher)

    override suspend fun shouldSkipAuth(): Boolean = withContext(dispatcher) {
        auth.currentUser != null && getRememberMe()
        // checking auth.currentUser for extreme scenarios
    }

    override suspend fun setRememberMe(flagRememberMe: Boolean) = withContext(dispatcher) {
        sp.edit { putBoolean(FLAG_REMEMBER_ME, flagRememberMe) }
    }

    override suspend fun getRememberMe(): Boolean = withContext(dispatcher) {
        sp.getBoolean(FLAG_REMEMBER_ME, false)
    }

    companion object {
        private const val FLAG_REMEMBER_ME = "flag_remember_me"
    }
}