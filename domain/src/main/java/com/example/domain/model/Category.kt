package com.example.domain.model

enum class Category(
    val categoryID: String,
    val displayName: String,
    val itemCount: Int
) {
    SHOES("shoes", "Shoes", 128),
    BAGS("bags", "Bags", 86),
    WATCHES("watches", "Watches", 54),
    TECH("tech", "Tech", 210),
    BEAUTY("beauty", "Beauty", 97),
    SPORTS("sports", "Sports", 64),
    CLOTHING("clothing", "Clothing", 175),
    ACCESSORIES("accessories", "Accessories", 112)
}