package com.example.presentation.ui.more.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class MoreViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<MoreScreenState, MoreEffect> {
    override val container = container<MoreScreenState, MoreEffect>(initialState = MoreScreenState.INITIAL)
}