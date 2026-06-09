package com.example.presentation.di

import com.example.presentation.ui.auth.login.mvi.LoginViewModel
import com.example.presentation.ui.auth.register.mvi.RegisterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        RegisterViewModel(authRepository = get())
    }
    viewModel {
        LoginViewModel(authRepository = get())
    }
}