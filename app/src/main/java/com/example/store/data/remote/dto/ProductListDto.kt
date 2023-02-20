package com.example.store.data.remote.dto

import com.example.store.domain.model.ProductList

data class ProductListDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)

fun ProductListDto.toProductList() : ProductList {
    return ProductList(category, description, id, image, price, rating, title)
}