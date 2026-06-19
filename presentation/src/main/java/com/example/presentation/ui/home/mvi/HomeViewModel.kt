package com.example.presentation.ui.home.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

internal class HomeViewModel(
    override val container: Container<HomeScreenState, HomeEffect>
) : ViewModel(), ContainerHost<HomeScreenState, HomeEffect> {

}