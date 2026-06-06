package com.example.domain.repository

import com.example.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories() : Result<List<Category>>
}