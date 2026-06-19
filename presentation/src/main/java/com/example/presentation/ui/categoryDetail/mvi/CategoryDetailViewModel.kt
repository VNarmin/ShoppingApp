package com.example.presentation.ui.categoryDetail.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class CategoryDetailViewModel(
    // constructor parameters
) : ViewModel(), ContainerHost<CategoryDetailScreenState, CategoryDetailEffect> {
    override val container = container<CategoryDetailScreenState, CategoryDetailEffect>(initialState = CategoryDetailScreenState.INITIAL)
}