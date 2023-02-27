package com.example.store.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.store.data.local.entity.ProductListEntity

@Database(
    entities = [ProductListEntity::class],
    version = 1
)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productListDao(): ProductListDao
}
