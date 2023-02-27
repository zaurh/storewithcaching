package com.example.store.domain.repository

import com.example.store.common.Resource
import com.example.store.data.remote.dto.ProductListDto
import com.example.store.domain.model.Product
import com.example.store.domain.model.ProductList
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getProductList(): Flow<Resource<List<ProductList>>>

    fun getProduct(id: String): Flow<Resource<Product>>

}