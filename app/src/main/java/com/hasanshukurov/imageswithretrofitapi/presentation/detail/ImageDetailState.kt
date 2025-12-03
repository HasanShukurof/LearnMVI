package com.hasanshukurov.imageswithretrofitapi.presentation.detail

import com.hasanshukurov.imageswithretrofitapi.domain.model.Image

/**
 * ImageDetailState - Şəkil detalları ekranının UI state-i
 */
data class ImageDetailState(
    val image: Image? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)


