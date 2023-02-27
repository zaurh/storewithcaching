package com.example.store.di

import android.app.Application
import androidx.room.Room
import com.example.store.common.Constants.BASE_URL
import com.example.store.data.local.ProductDatabase
import com.example.store.data.remote.StoreApi
import com.example.store.data.repository.RepositoryImpl
import com.example.store.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): StoreApi{
        return retrofit.create(StoreApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: StoreApi,
        productListDatabase: ProductDatabase,
    ): Repository =
        RepositoryImpl(api,productListDatabase.productListDao())

    @Singleton
    @Provides
    fun provideProductListDatabase(app: Application): ProductDatabase {
        return Room.databaseBuilder(
            app,
            ProductDatabase::class.java,
            "product_db"
        ).build()
    }

}