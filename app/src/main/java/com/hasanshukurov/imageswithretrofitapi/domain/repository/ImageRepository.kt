package com.hasanshukurov.imageswithretrofitapi.domain.repository

import com.hasanshukurov.imageswithretrofitapi.domain.model.Image
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository Interface - Domain Layer-də yerləşir
 * Data Layer bu interface-i implement edəcək
 * Bu, Dependency Inversion prinsipini təmin edir
 */
interface ImageRepository {
    
    /**
     * Bütün şəkilləri əldə etmək üçün
     * Flow istifadə edirik ki, reactive data stream olsun
     */
    fun getAllImages(): Flow<Resource<List<Image>>>
    
    /**
     * ID-yə görə tək şəkil əldə etmək üçün
     */
    suspend fun getImageById(id: String): Resource<Image>
}


