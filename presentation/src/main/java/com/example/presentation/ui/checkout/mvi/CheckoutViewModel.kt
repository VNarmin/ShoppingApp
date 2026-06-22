package com.example.presentation.ui.checkout.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CheckoutViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<CheckoutScreenState, CheckoutEffect> {
    override val container = container<CheckoutScreenState, CheckoutEffect>(initialState = CheckoutScreenState.INITIAL)
}