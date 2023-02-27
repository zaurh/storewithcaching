package com.example.store.data.remote.dto

import com.example.store.domain.model.Product

data class ProductDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

fun ProductDto.toProduct(): Product {
    return Product(category, description, id, image, price, title)
}