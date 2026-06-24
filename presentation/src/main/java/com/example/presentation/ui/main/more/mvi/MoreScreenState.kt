package com.example.presentation.ui.main.more.mvi

import com.example.domain.model.Category

internal data class MoreScreenState(
    val username: String = "",
    val categories: List<Category> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    companion object {
        val INITIAL = MoreScreenState()
    }
}