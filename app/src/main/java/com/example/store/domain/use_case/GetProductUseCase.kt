package com.example.store.domain.use_case

import com.example.store.common.Resource
import com.example.store.domain.model.Product
import com.example.store.domain.model.ProductList
import com.example.store.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(id: String): Flow<Resource<Product>> {
        return repository.getProduct(id)
    }

}