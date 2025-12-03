package com.hasanshukurov.imageswithretrofitapi.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * ImageDto - API-dan gələn şəkil data-sı üçün DTO (Data Transfer Object)
 * Bu class yalnız Data Layer-də istifadə olunur
 */
data class ImageDto(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("url")
    val url: String,
    
    @SerializedName("width")
    val width: Int,
    
    @SerializedName("height")
    val height: Int,
    
    @SerializedName("box_count")
    val boxCount: Int,
    
    @SerializedName("captions")
    val captions: Int
)


