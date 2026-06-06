package com.example.data.repository

import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository

class CategoryRepositoryImpl : CategoryRepository {
    override suspend fun getCategories(): Result<List<Category>> {
        TODO("Not yet implemented")
    }

}