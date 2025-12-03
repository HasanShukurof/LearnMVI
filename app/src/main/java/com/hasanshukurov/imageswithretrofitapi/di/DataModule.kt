package com.hasanshukurov.imageswithretrofitapi.di

import com.hasanshukurov.imageswithretrofitapi.data.remote.api.ImageApi
import com.hasanshukurov.imageswithretrofitapi.data.remote.datasource.RemoteDataSource
import com.hasanshukurov.imageswithretrofitapi.data.remote.datasource.RemoteDataSourceImpl
import com.hasanshukurov.imageswithretrofitapi.data.repository.ImageRepositoryImpl
import com.hasanshukurov.imageswithretrofitapi.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DataModule - Data layer dependency-lərini təmin edir
 * 
 * Repository və DataSource binding-ləri burada edilir
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    
    /**
     * RemoteDataSource implementation-ını provide edir
     */
    @Provides
    @Singleton
    fun provideRemoteDataSource(api: ImageApi): RemoteDataSource {
        return RemoteDataSourceImpl(api)
    }
    
    /**
     * ImageRepository implementation-ını provide edir
     * 
     * Domain Layer-dəki interface-i Data Layer-dəki
     * implementation ilə bağlayırıq
     */
    @Provides
    @Singleton
    fun provideImageRepository(remoteDataSource: RemoteDataSource): ImageRepository {
        return ImageRepositoryImpl(remoteDataSource)
    }
}


