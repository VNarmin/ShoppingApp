package com.example.presentation.ui.cart.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CartViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<CartScreenState, CartEffect> {
    override val container = container<CartScreenState, CartEffect>(initialState = CartScreenState.INITIAL)
}