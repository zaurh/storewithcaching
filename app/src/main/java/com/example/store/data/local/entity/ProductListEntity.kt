package com.example.store.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.store.domain.model.ProductList

@Entity
data class ProductListEntity(
    @PrimaryKey(autoGenerate = true) val productListId: Int? = null,
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)


fun ProductListEntity.toProductList(): ProductList{
    return ProductList(category = category, description = description, id = id,
    image = image, price = price, title = title)
}