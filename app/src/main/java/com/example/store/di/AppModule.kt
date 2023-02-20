package com.example.store.di

import com.example.store.common.Constants.BASE_URL
import com.example.store.data.remote.StoreApi
import com.example.store.data.repository.RepositoryImpl
import com.example.store.domain.repository.Repository
import com.example.store.domain.use_case.GetProductListUseCase
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
    fun provideRepository(api: StoreApi): Repository = RepositoryImpl(api)

    @Singleton
    @Provides
    fun provideUseCase(repository: Repository) = GetProductListUseCase(repository)
}