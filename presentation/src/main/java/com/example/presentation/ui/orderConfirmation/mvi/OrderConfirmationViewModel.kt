package com.example.presentation.ui.orderConfirmation.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class OrderConfirmationViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<OrderConfirmationScreenState, OrderConfirmationEffect> {

    override val container = container<OrderConfirmationScreenState, OrderConfirmationEffect>(
        initialState = OrderConfirmationScreenState.INITIAL
    )
}