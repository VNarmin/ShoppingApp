package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.mock.MockCategories
import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

internal class CategoryRepositoryImpl : CategoryRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        delay(duration = 500.milliseconds)
        val categories = MockCategories.all.toDomain()
        emit(categories)
    }

    override fun getCategoryDetails(categoryID: String): Flow<Category> = flow {
        delay(duration = 500.milliseconds)
        val category = MockCategories.all.find { category ->
            category.categoryID == categoryID
        }?.toDomain() ?: throw NoSuchElementException("Category Not Found")
        emit(category)
    }
}