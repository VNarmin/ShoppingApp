package com.example.presentation.ui.more.mvi

import com.example.domain.model.Category

data class MoreScreenState(
    val username: String = "Narmin",
    val categories: List<Category> = emptyList(),
    val loading: Boolean = false,
    val errorMessage: String? = null
)