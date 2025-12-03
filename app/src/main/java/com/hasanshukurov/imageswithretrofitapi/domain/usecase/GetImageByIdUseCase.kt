package com.hasanshukurov.imageswithretrofitapi.domain.usecase

import com.hasanshukurov.imageswithretrofitapi.domain.model.Image
import com.hasanshukurov.imageswithretrofitapi.domain.repository.ImageRepository
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import javax.inject.Inject

/**
 * GetImageByIdUseCase - ID-yə görə tək şəkil əldə etmək üçün UseCase
 */
class GetImageByIdUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(id: String): Resource<Image> {
        return repository.getImageById(id)
    }
}


