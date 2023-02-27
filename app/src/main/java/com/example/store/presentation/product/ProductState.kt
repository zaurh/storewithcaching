package com.example.store.presentation.product

import com.example.store.domain.model.Product

data class ProductState(
    val product: Product? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
