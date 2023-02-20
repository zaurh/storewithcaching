package com.example.store.domain.use_case

import com.example.store.common.Resource
import com.example.store.data.remote.dto.toProductList
import com.example.store.domain.model.ProductList
import com.example.store.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<ProductList>>> = flow {
        try {
            emit(Resource.Loading())
            val productList = repository.getProductList().map { it.toProductList() }
            emit(Resource.Success(productList))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

}