package com.example.store.data.repository

import com.example.store.common.Resource
import com.example.store.data.local.ProductListDao
import com.example.store.data.local.entity.toProductList
import com.example.store.data.remote.StoreApi
import com.example.store.data.remote.dto.toProduct
import com.example.store.data.remote.dto.toProductListEntity
import com.example.store.domain.model.Product
import com.example.store.domain.model.ProductList
import com.example.store.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val storeApi: StoreApi,
    private val productListDao: ProductListDao
):Repository {

    override fun getProductList(): Flow<Resource<List<ProductList>>> = flow{
        emit(Resource.Loading())
        val localData = productListDao.butunProductlar().map { it.toProductList() }
        emit(Resource.Loading(data = localData))

        try {
            val remoteData = storeApi.getProductList()
            productListDao.deleteAll()
            productListDao.Insert(remoteData.map { it.toProductListEntity() })
        }
        catch (e: HttpException){
            emit(Resource.Error(
                message = "sehlvik",
                data = localData
            ))
        }
        catch (e: IOException){
            emit(Resource.Error(
                message = "sehlvik",
                data = localData
            ))
        }

        val newData = productListDao.butunProductlar().map { it.toProductList() }
        emit(Resource.Success(data = newData))
    }

    override fun getProduct(id: String): Flow<Resource<Product>> = flow {
        try {
            emit(Resource.Loading())
            val remoteData = storeApi.getProduct(id).toProduct()
            emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(
                message = "Sehv"
            ))
        }
    }
}