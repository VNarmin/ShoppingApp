package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.repository.AuthRepositoryImpl
import com.example.data.repository.CategoryRepositoryImpl
import com.example.data.repository.ProductRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.ProductRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single { Firebase.auth }

    single<SharedPreferences> {
        get<Context>().getSharedPreferences(
            "app_prefs",
            Context.MODE_PRIVATE
        )
    }

    // not strictly necessary, but essential for testability
    single<CoroutineDispatcher> { Dispatchers.IO }

    single<AuthRepository> {
        AuthRepositoryImpl(
            auth = get(),
            sp = get(),
            dispatcher = get()
        )
    }

    single<CategoryRepository> {
        CategoryRepositoryImpl(dispatcher = get())
    }

    single<ProductRepository> {
        ProductRepositoryImpl(dispatcher = get())
    }
}