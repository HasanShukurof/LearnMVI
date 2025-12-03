package com.hasanshukurov.imageswithretrofitapi.presentation.images

import com.hasanshukurov.imageswithretrofitapi.domain.model.Image

/**
 * ImageListState - Şəkillər siyahısı ekranının UI state-i
 * 
 * Bu data class UI-ın bütün mümkün vəziyyətlərini təsvir edir
 * ViewModel bu state-i saxlayır və UI ona subscribe olur
 */
data class ImageListState(
    val images: List<Image> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)


