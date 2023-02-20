package com.example.store.data.repository

import com.example.store.data.remote.StoreApi
import com.example.store.data.remote.dto.ProductListDto
import com.example.store.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val storeApi: StoreApi
):Repository {

    override suspend fun getProductList(): List<ProductListDto> {
        return storeApi.getProductList()
    }
}