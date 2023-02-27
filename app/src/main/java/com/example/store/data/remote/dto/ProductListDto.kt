package com.example.store.data.remote.dto

import com.example.store.data.local.entity.ProductListEntity

data class ProductListDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

fun ProductListDto.toProductListEntity() : ProductListEntity {
    return ProductListEntity(category = category, description = description, id = id,
    image = image, price = price, title = title)
}