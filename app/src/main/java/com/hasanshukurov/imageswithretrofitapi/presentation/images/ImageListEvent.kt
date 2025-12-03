package com.hasanshukurov.imageswithretrofitapi.presentation.images

/**
 * ImageListEvent - Şəkillər siyahısı ekranında baş verə biləcək event-lər
 * 
 * Bu sealed class UI-dan ViewModel-ə göndərilən event-ləri təsvir edir
 * MVI pattern-in bir hissəsidir
 */
sealed class ImageListEvent {
    object LoadImages : ImageListEvent()
    object RefreshImages : ImageListEvent()
}


