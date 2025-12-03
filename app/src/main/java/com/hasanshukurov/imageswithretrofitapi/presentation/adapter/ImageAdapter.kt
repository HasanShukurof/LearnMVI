package com.hasanshukurov.imageswithretrofitapi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hasanshukurov.imageswithretrofitapi.databinding.RecyclerRowBinding
import com.hasanshukurov.imageswithretrofitapi.domain.model.Image
import com.squareup.picasso.Picasso

/**
 * ImageAdapter - RecyclerView üçün adapter
 * 
 * ListAdapter istifadə edirik ki, DiffUtil avtomatik işləsin
 * Bu performans üçün daha yaxşıdır
 */
class ImageAdapter(
    private val onItemClick: (Image) -> Unit
) : ListAdapter<Image, ImageAdapter.ImageViewHolder>(ImageDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = RecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class ImageViewHolder(
        private val binding: RecyclerRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }
        }
        
        fun bind(image: Image) {
            binding.textView.text = image.name
            Picasso.get()
                .load(image.url)
                .into(binding.imageView)
        }
    }
    
    /**
     * DiffUtil.ItemCallback - Siyahı yeniləmələrini optimallaşdırır
     */
    private class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }
}


