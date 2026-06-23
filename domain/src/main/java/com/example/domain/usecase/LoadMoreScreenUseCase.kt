package com.example.domain.usecase

import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CategoryRepository

class LoadMoreScreenUseCase(
    private val authRepository: AuthRepository,
    private val categoryRepository: CategoryRepository
) {
    fun getCurrentUser() = authRepository.getCurrentUser()

    fun getCategories() = categoryRepository.getCategories()
}