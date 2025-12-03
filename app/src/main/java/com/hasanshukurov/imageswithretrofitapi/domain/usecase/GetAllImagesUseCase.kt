package com.hasanshukurov.imageswithretrofitapi.domain.usecase

import com.hasanshukurov.imageswithretrofitapi.domain.model.Image
import com.hasanshukurov.imageswithretrofitapi.domain.repository.ImageRepository
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * GetAllImagesUseCase - Bütün şəkilləri əldə etmək üçün UseCase
 * 
 * UseCase-lər business logic-i özündə saxlayır
 * Hər UseCase yalnız bir iş görür (Single Responsibility)
 */
class GetAllImagesUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    /**
     * invoke operator istifadə edirik ki, UseCase-i funksiya kimi çağıra bilək
     * Məsələn: getAllImagesUseCase() şəklində
     */
    operator fun invoke(): Flow<Resource<List<Image>>> {
        return repository.getAllImages()
    }
}


