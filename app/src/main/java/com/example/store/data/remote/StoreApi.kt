package com.example.store.data.remote

import com.example.store.data.remote.dto.ProductDto
import com.example.store.data.remote.dto.ProductListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {
    @GET("products")
    suspend fun getProductList(): List<ProductListDto>

    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id: String
    ): ProductDto
}

