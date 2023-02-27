package com.example.store.data.local

import androidx.room.*
import com.example.store.data.local.entity.ProductListEntity

@Dao
interface ProductListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(productListEntity: List<ProductListEntity>)

    @Query("DELETE FROM productlistentity")
    suspend fun deleteAll()

    @Query("SELECT * FROM productlistentity")
    suspend fun butunProductlar():List<ProductListEntity>
}


