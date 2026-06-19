package com.example.presentation.ui.orderConfirmation.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class OrderConfirmationViewModel(
    override val container: Container<OrderConfirmationScreenState, OrderConfirmationEffect>
) : ViewModel(), ContainerHost<OrderConfirmationScreenState, OrderConfirmationEffect> {

}