package com.hasanshukurov.imageswithretrofitapi.data.repository

import com.hasanshukurov.imageswithretrofitapi.data.mapper.toDomainList
import com.hasanshukurov.imageswithretrofitapi.data.remote.datasource.RemoteDataSource
import com.hasanshukurov.imageswithretrofitapi.domain.model.Image
import com.hasanshukurov.imageswithretrofitapi.domain.repository.ImageRepository
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * ImageRepositoryImpl - ImageRepository interface-inin implementasiyası
 * 
 * Bu class Data Layer-də yerləşir və Domain Layer-dəki interface-i implement edir
 * Remote və Local data source-lardan data əldə edir və Domain model-ə çevirir
 */
class ImageRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ImageRepository {
    
    // Cache - sadə in-memory cache
    private var cachedImages: List<Image>? = null
    
    override fun getAllImages(): Flow<Resource<List<Image>>> = flow {
        // Əvvəlcə Loading state emit edirik
        emit(Resource.Loading())
        
        try {
            // API-dan data çəkirik
            val response = remoteDataSource.getAllImages()
            
            if (response.isSuccessful && response.body() != null) {
                val imageResponse = response.body()!!
                
                if (imageResponse.success) {
                    // DTO-ları Domain model-ə çeviririk
                    val images = imageResponse.data.images.toDomainList()
                    // Cache-ə yazırıq
                    cachedImages = images
                    // Success state emit edirik
                    emit(Resource.Success(images))
                } else {
                    emit(Resource.Error("API xətası: Uğursuz cavab"))
                }
            } else {
                emit(Resource.Error("API xətası: ${response.message()}"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error("HTTP xətası: ${e.message()}"))
        } catch (e: IOException) {
            emit(Resource.Error("Şəbəkə xətası: İnternet bağlantınızı yoxlayın"))
        } catch (e: Exception) {
            emit(Resource.Error("Gözlənilməz xəta: ${e.localizedMessage}"))
        }
    }
    
    override suspend fun getImageById(id: String): Resource<Image> {
        return try {
            // Əvvəlcə cache-dən axtarırıq
            cachedImages?.find { it.id == id }?.let { image ->
                return Resource.Success(image)
            }
            
            // Cache-də yoxdursa, API-dan çəkirik
            val response = remoteDataSource.getAllImages()
            
            if (response.isSuccessful && response.body() != null) {
                val imageResponse = response.body()!!
                
                if (imageResponse.success) {
                    val images = imageResponse.data.images.toDomainList()
                    cachedImages = images
                    
                    val image = images.find { it.id == id }
                    if (image != null) {
                        Resource.Success(image)
                    } else {
                        Resource.Error("Şəkil tapılmadı")
                    }
                } else {
                    Resource.Error("API xətası: Uğursuz cavab")
                }
            } else {
                Resource.Error("API xətası: ${response.message()}")
            }
        } catch (e: HttpException) {
            Resource.Error("HTTP xətası: ${e.message()}")
        } catch (e: IOException) {
            Resource.Error("Şəbəkə xətası: İnternet bağlantınızı yoxlayın")
        } catch (e: Exception) {
            Resource.Error("Gözlənilməz xəta: ${e.localizedMessage}")
        }
    }
}


