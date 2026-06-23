package com.example.domain.di

import com.example.domain.usecase.LoadCategoryDetailScreenUseCase
import com.example.domain.usecase.LoadHomeScreenUseCase
import com.example.domain.usecase.LoadMoreScreenUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        LoadCategoryDetailScreenUseCase(
            categoryRepository = get(),
            productRepository = get()
        )
    }

    factory {
        LoadMoreScreenUseCase(
            authRepository = get(),
            categoryRepository = get()
        )
    }

    factory {
        LoadHomeScreenUseCase(
            authRepository = get(),
            categoryRepository = get(),
            productRepository = get()
        )
    }
}