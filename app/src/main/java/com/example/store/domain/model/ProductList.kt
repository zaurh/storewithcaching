package com.example.store.domain.model

import com.example.store.data.remote.dto.RatingDto

data class ProductList(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)
