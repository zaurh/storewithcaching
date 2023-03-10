package com.example.store.domain.model

data class ProductList(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)
