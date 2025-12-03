package com.hasanshukurov.imageswithretrofitapi.di

import com.hasanshukurov.imageswithretrofitapi.data.remote.api.ImageApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * NetworkModule - Şəbəkə ilə bağlı dependency-ləri təmin edir
 * 
 * SingletonComponent istifadə edirik ki, bu dependency-lər
 * tətbiqin ömrü boyu yaşasın
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    /**
     * Retrofit instance yaradır
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ImageApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    /**
     * ImageApi instance yaradır
     */
    @Provides
    @Singleton
    fun provideImageApi(retrofit: Retrofit): ImageApi {
        return retrofit.create(ImageApi::class.java)
    }
}


