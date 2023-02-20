package com.example.store.domain.repository

import com.example.store.data.remote.dto.ProductListDto

interface Repository {

    suspend fun getProductList(): List<ProductListDto>
}