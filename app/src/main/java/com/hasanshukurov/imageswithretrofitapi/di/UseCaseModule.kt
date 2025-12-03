package com.hasanshukurov.imageswithretrofitapi.di

import com.hasanshukurov.imageswithretrofitapi.domain.repository.ImageRepository
import com.hasanshukurov.imageswithretrofitapi.domain.usecase.GetAllImagesUseCase
import com.hasanshukurov.imageswithretrofitapi.domain.usecase.GetImageByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * UseCaseModule - UseCase dependency-lərini təmin edir
 * 
 * ViewModelComponent istifadə edirik ki, UseCase-lər
 * ViewModel-in ömrü ilə bağlı olsun
 */
@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    
    /**
     * GetAllImagesUseCase provide edir
     */
    @Provides
    @ViewModelScoped
    fun provideGetAllImagesUseCase(repository: ImageRepository): GetAllImagesUseCase {
        return GetAllImagesUseCase(repository)
    }
    
    /**
     * GetImageByIdUseCase provide edir
     */
    @Provides
    @ViewModelScoped
    fun provideGetImageByIdUseCase(repository: ImageRepository): GetImageByIdUseCase {
        return GetImageByIdUseCase(repository)
    }
}


