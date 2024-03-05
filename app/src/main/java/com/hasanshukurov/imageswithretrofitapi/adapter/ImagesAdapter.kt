package com.hasanshukurov.imageswithretrofitapi.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.hasanshukurov.imageswithretrofitapi.R
import com.hasanshukurov.imageswithretrofitapi.data.Images
import com.hasanshukurov.imageswithretrofitapi.databinding.RecyclerRowBinding
import com.hasanshukurov.imageswithretrofitapi.view.ImagesFragmentDirections
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ImagesAdapter @Inject constructor(var imageList: List<Images> ): RecyclerView.Adapter<ImagesAdapter.ImagesHolder>() {
    class ImagesHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImagesHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {

        Picasso.get().load(imageList[position].url).into(holder.binding.imageView)
        holder.binding.textView.text = imageList[position].name

        val bundle = Bundle().apply {
            putSerializable("imageArgs", imageList[position])
        }

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_imagesFragment_to_imageDetailFragment,bundle)
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}