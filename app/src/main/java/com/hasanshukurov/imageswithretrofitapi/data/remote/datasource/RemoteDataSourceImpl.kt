package com.hasanshukurov.imageswithretrofitapi.data.remote.datasource

import com.hasanshukurov.imageswithretrofitapi.data.remote.api.ImageApi
import com.hasanshukurov.imageswithretrofitapi.data.remote.dto.ImageResponseDto
import retrofit2.Response
import javax.inject.Inject

/**
 * RemoteDataSourceImpl - RemoteDataSource interface-inin implementasiyası
 * API ilə birbaşa əlaqə bu class-da baş verir
 */
class RemoteDataSourceImpl @Inject constructor(
    private val api: ImageApi
) : RemoteDataSource {
    
    override suspend fun getAllImages(): Response<ImageResponseDto> {
        return api.getAllImages()
    }
}


