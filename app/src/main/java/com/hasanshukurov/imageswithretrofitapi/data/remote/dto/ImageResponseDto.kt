package com.hasanshukurov.imageswithretrofitapi.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * ImageResponseDto - API-dan gələn əsas cavab üçün DTO
 */
data class ImageResponseDto(
    @SerializedName("data")
    val data: ImageDataDto,
    
    @SerializedName("success")
    val success: Boolean
)


