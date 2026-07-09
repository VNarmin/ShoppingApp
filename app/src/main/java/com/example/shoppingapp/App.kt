package com.example.shoppingapp

import android.app.Application
import com.example.shoppingapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// Application -- the first Android component that is created when my app launches
// by creating a custom class extending Application,
// I get a place to perform app-wide initialization that should happen only once
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}