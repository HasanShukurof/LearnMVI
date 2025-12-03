package com.hasanshukurov.imageswithretrofitapi.data.remote.api

import com.hasanshukurov.imageswithretrofitapi.data.remote.dto.ImageResponseDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * ImageApi - Retrofit API interface
 * Remote data source ilə əlaqə üçün istifadə olunur
 */
interface ImageApi {
    
    @GET("get_memes")
    suspend fun getAllImages(): Response<ImageResponseDto>
    
    companion object {
        const val BASE_URL = "https://api.imgflip.com/"
    }
}


