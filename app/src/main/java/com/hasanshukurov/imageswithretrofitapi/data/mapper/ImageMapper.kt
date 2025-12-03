package com.hasanshukurov.imageswithretrofitapi.data.mapper

import com.hasanshukurov.imageswithretrofitapi.data.remote.dto.ImageDto
import com.hasanshukurov.imageswithretrofitapi.domain.model.Image

/**
 * ImageMapper - DTO-dan Domain Model-ə çevirmək üçün extension funksiyalar
 * 
 * Bu mapper Data Layer ilə Domain Layer arasında köprü rolunu oynayır
 * Domain Layer heç vaxt DTO-ları bilməməlidir
 */

/**
 * ImageDto-nu Domain Entity-yə çevirir
 */
fun ImageDto.toDomain(): Image {
    return Image(
        id = id,
        name = name,
        url = url,
        width = width,
        height = height,
        boxCount = boxCount,
        captions = captions
    )
}

/**
 * ImageDto siyahısını Domain Entity siyahısına çevirir
 */
fun List<ImageDto>.toDomainList(): List<Image> {
    return map { it.toDomain() }
}


