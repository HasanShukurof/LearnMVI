package com.hasanshukurov.imageswithretrofitapi.domain.model

/**
 * Domain Entity - Business logic üçün istifadə olunan model
 * Bu model heç bir framework-dən asılı deyil (Pure Kotlin)
 */
data class Image(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int,
    val boxCount: Int,
    val captions: Int
)


