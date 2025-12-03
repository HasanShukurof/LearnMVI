package com.hasanshukurov.imageswithretrofitapi.domain.util

/**
 * Resource - API cavablarını wrap etmək üçün sealed class
 * Loading, Success və Error state-lərini idarə edir
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}


