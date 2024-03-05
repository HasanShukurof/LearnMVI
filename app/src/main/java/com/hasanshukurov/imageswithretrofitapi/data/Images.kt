package com.hasanshukurov.imageswithretrofitapi.data

data class Images(
    val box_count: Int,
    val captions: Int,
    val height: Int,
    val id: String,
    val name: String,
    val url: String,
    val width: Int
) : java.io.Serializable