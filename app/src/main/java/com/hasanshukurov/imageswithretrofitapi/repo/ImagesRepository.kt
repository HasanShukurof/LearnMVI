package com.hasanshukurov.imageswithretrofitapi.repo

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hasanshukurov.imageswithretrofitapi.data.AllImagesData
import com.hasanshukurov.imageswithretrofitapi.data.Images
import com.hasanshukurov.imageswithretrofitapi.data.service.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImagesRepository @Inject constructor(
    private val api: Api
    ) {
    suspend fun getAllImagesRepo() : List<Images> {
        return api.getAllData().body()!!.data.images
    }

        /*       return try {

            val response = api.getAllData()

            if (response.isSuccessful){
                response.body()?.let {
                    Resource.success(it)
                } ?: Resource.error("No Data",null)
            }else{
                Resource.error("No Data",null)
            }


        }catch (e:Exception){
            Resource.error("No Data",null)
        }

  */

}