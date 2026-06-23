package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.repository.AuthRepositoryImpl
import com.example.data.repository.CategoryRepositoryImpl
import com.example.data.repository.ProductRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import org.koin.dsl.module

val dataModule = module {
    single { Firebase.auth }

    single<SharedPreferences> {
        get<Context>().getSharedPreferences(
            "app_prefs",
            Context.MODE_PRIVATE
        )
    }

    single<AuthRepository> {
        AuthRepositoryImpl(
            auth = get(),
            sp = get()
        )
    }

    single<CategoryRepositoryImpl> {
        CategoryRepositoryImpl()
    }

    single<ProductRepositoryImpl> {
        ProductRepositoryImpl()
    }
}