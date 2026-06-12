package com.example.data.mapper

import com.example.data.dto.CategoryDTO
import com.example.domain.model.Category

fun CategoryDTO.toDomain(): Category {
    return Category(
        categoryID = this.categoryID.orEmpty(),
        displayName = this.displayName.orEmpty(),
        itemCount = this.itemCount ?: 0
    )
}

fun List<CategoryDTO>.toDomain(): List<Category> = mapNotNull { category -> category.toDomain() }