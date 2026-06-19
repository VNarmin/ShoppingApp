package com.example.presentation.ui.more.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class MoreViewModel(
    override val container: Container<MoreScreenState, MoreEffect>
) : ViewModel(), ContainerHost<MoreScreenState, MoreEffect> {

}