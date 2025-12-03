package com.hasanshukurov.imageswithretrofitapi.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * ImageDataDto - API cavabındakı "data" obyekti üçün DTO
 */
data class ImageDataDto(
    @SerializedName("memes")
    val images: List<ImageDto>
)


