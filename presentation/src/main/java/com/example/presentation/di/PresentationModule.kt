package com.example.presentation.di

import com.example.presentation.ui.auth.login.mvi.LoginViewModel
import com.example.presentation.ui.auth.register.mvi.RegisterViewModel
import com.example.presentation.ui.main.cart.mvi.CartViewModel
import com.example.presentation.ui.main.categoryDetail.mvi.CategoryDetailViewModel
import com.example.presentation.ui.main.checkout.mvi.CheckoutViewModel
import com.example.presentation.ui.main.home.mvi.HomeViewModel
import com.example.presentation.ui.main.more.mvi.MoreViewModel
import com.example.presentation.ui.main.orderConfirmation.mvi.OrderConfirmationViewModel
import com.example.presentation.ui.main.productDetail.mvi.ProductDetailViewModel
import com.example.presentation.ui.splash.mvi.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        RegisterViewModel(authRepository = get())
    }
    viewModel {
        LoginViewModel(authRepository = get())
    }
    viewModel {
        CartViewModel(cartRepository = get())
    }
    viewModel {
        CategoryDetailViewModel(
            categoryRepository = get(),
            productRepository = get()
        )
    }
    viewModel {
        CheckoutViewModel(
            authRepository = get(),
            cartRepository = get()
        )
    }
    viewModel {
        HomeViewModel(
            authRepository = get(),
            categoryRepository = get(),
            productRepository = get()
        )
    }
    viewModel {
        MoreViewModel(
            authRepository = get(),
            categoryRepository = get()
        )
    }
    viewModel {
        OrderConfirmationViewModel(cartRepository = get())
    }
    viewModel {
        ProductDetailViewModel(
            productRepository = get(),
            cartRepository = get()
        )
    }
    viewModel {
        SplashViewModel(authRepository = get())
    }
}