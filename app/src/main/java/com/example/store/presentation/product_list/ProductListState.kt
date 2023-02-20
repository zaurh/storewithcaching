package com.example.store.presentation.product_list

import com.example.store.domain.model.ProductList

data class ProductListState(
    val productList: List<ProductList> = emptyList(),
    val error: String = "",
    var isLoading: Boolean = false
)
