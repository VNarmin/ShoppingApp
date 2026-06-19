package com.example.presentation.ui.checkout.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class CheckoutViewModel(
    override val container: Container<CheckoutScreenState, CheckoutEffect>
    // constructor parameters
) : ViewModel(), ContainerHost<CheckoutScreenState, CheckoutEffect> {

}