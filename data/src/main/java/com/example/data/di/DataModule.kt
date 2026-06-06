package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.mock.MockCategories
import com.example.data.mock.MockProducts
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

    single { MockProducts }

    single { MockCategories }
}