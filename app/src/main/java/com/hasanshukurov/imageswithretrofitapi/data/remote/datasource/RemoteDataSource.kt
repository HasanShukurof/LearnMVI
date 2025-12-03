package com.hasanshukurov.imageswithretrofitapi.data.remote.datasource

import com.hasanshukurov.imageswithretrofitapi.data.remote.dto.ImageResponseDto
import retrofit2.Response

/**
 * RemoteDataSource Interface - Remote data source üçün abstraction
 * Bu interface sayəsində remote data source-u asanlıqla mock edə bilərik (test üçün)
 */
interface RemoteDataSource {
    suspend fun getAllImages(): Response<ImageResponseDto>
}


