package com.example.store.data.remote

import com.example.store.data.remote.dto.ProductListDto
import retrofit2.http.GET

interface StoreApi {
    @GET("products")
    suspend fun getProductList(): List<ProductListDto>
}

