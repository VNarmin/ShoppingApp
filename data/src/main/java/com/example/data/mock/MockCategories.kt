package com.example.data.mock

import com.example.data.dto.CategoryDTO

internal object MockCategories {
    val all = listOf(
        CategoryDTO(categoryID = "all",         displayName = "All",         itemCount = 926),
        CategoryDTO(categoryID = "shoes",       displayName = "Shoes",       itemCount = 128),
        CategoryDTO(categoryID = "bags",        displayName = "Bags",        itemCount = 86),
        CategoryDTO(categoryID = "watches",     displayName = "Watches",     itemCount = 54),
        CategoryDTO(categoryID = "tech",        displayName = "Tech",        itemCount = 210),
        CategoryDTO(categoryID = "beauty",      displayName = "Beauty",      itemCount = 97),
        CategoryDTO(categoryID = "sports",      displayName = "Sports",      itemCount = 64),
        CategoryDTO(categoryID = "clothing",    displayName = "Clothing",    itemCount = 175),
        CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112)
    )
}