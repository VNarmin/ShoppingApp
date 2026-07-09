package com.example.domain.model

data class Product(
    val productID: String,
    val name: String,
    val description: String,
    val price: Double,
    val images: List<String>,
    val category: Category?,
    val stockCount: Int,
    val rating: Double,
    val reviewCount: Int
) {
    val inStock: Boolean get() = stockCount > 0
}

// Compose cannot statically prove a List<T> will not be mutated elsewhere,
// so it treats it as unstable and may recompose more than necessary.
// ImmutableList gives Compose a compile-time guarantee,
// which matters for UI states.