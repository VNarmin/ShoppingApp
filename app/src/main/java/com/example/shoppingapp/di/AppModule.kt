package com.example.shoppingapp.di

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule

val appModule = listOf(
    dataModule,
    domainModule,
    presentationModule
)