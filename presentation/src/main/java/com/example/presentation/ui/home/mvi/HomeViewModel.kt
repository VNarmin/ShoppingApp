package com.example.presentation.ui.home.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class HomeViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<HomeScreenState, HomeEffect> {
    override val container = container<HomeScreenState, HomeEffect>(initialState = HomeScreenState.INITIAL)
}