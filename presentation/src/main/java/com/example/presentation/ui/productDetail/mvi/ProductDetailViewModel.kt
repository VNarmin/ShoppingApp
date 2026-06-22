package com.example.presentation.ui.productDetail.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class ProductDetailViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<ProductDetailScreenState, ProductDetailEffect> {
    override val container = container<ProductDetailScreenState, ProductDetailEffect>(initialState = ProductDetailScreenState.INITIAL)
}