package com.hasanshukurov.imageswithretrofitapi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hasanshukurov.imageswithretrofitapi.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity - Tətbiqin əsas activity-si
 * 
 * Single Activity pattern istifadə edirik
 * Bütün ekranlar Fragment-lər vasitəsilə göstərilir
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        supportActionBar?.hide()
    }
}


