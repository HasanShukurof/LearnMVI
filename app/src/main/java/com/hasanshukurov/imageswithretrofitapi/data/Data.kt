package com.hasanshukurov.imageswithretrofitapi.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("memes")
    val images: List<Images>
)