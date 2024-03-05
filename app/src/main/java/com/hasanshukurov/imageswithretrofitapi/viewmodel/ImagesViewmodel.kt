package com.hasanshukurov.imageswithretrofitapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.imageswithretrofitapi.data.AllImagesData
import com.hasanshukurov.imageswithretrofitapi.data.Images
import com.hasanshukurov.imageswithretrofitapi.repo.ImagesRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewmodel @Inject constructor(
    private val repo: ImagesRepository
    ): ViewModel() {

    val imageList = MutableLiveData<List<Images>>()




    fun getAllImagesVM(){
        viewModelScope.launch {
            imageList.value = repo.getAllImagesRepo()
        }
    }





}