package com.example.presentation.ui.productDetail.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class ProductDetailViewModel(
    override val container: Container<ProductDetailScreenState, ProductDetailEffect>
) : ViewModel(), ContainerHost<ProductDetailScreenState, ProductDetailEffect> {

}