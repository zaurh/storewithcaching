package com.example.store.domain.use_case

import com.example.store.common.Resource
import com.example.store.domain.model.ProductList
import com.example.store.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<ProductList>>> {
        return repository.getProductList()
    }

}