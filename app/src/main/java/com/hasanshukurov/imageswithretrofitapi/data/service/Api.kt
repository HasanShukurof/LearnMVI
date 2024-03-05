package com.hasanshukurov.imageswithretrofitapi.data.service

import com.hasanshukurov.imageswithretrofitapi.data.AllImagesData
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("get_memes")
    suspend fun getAllData(): Response<AllImagesData>
}