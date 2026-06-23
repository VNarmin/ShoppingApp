package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.mock.MockCategories
import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.time.Duration.Companion.milliseconds

internal class CategoryRepositoryImpl(
    private val dispatcher: CoroutineDispatcher
) : CategoryRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        delay(duration = 500.milliseconds)
        val categories = MockCategories.all.toDomain()
        emit(categories)
    }.flowOn(context = dispatcher)

    override fun getCategoryDetails(categoryID: String): Flow<Category> = flow {
        delay(duration = 500.milliseconds)
        val category = MockCategories.all.find { category ->
            category.categoryID == categoryID
        }?.toDomain() ?: throw NoSuchElementException("Category Not Found")
        emit(category)
    }.flowOn(context = dispatcher)
}