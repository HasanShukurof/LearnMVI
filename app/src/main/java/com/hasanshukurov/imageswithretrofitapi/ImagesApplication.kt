package com.hasanshukurov.imageswithretrofitapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * ImagesApplication - Tətbiqin Application class-ı
 * 
 * @HiltAndroidApp annotasiyası Hilt-in işləməsi üçün lazımdır
 * Bu annotasiya tətbiqin dependency injection container-ını yaradır
 */
@HiltAndroidApp
class ImagesApplication : Application()


