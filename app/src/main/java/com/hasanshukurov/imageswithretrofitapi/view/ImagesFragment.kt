package com.hasanshukurov.imageswithretrofitapi.view


import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.RequestManager
import com.hasanshukurov.imageswithretrofitapi.adapter.ImagesAdapter
import com.hasanshukurov.imageswithretrofitapi.data.Images
import com.hasanshukurov.imageswithretrofitapi.databinding.FragmentImagesBinding
import com.hasanshukurov.imageswithretrofitapi.viewmodel.ImagesViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagesFragment () : Fragment() {

    private lateinit var binding: FragmentImagesBinding
    private lateinit var viewmModel: ImagesViewmodel
    private lateinit var imageAdapter: ImagesAdapter
 //   var imagesList = ArrayList<Images>()
 //   private lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x : ImagesViewmodel by viewModels()
        viewmModel = x


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImagesBinding.inflate(inflater,container,false)


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewmModel.imageList.observe(viewLifecycleOwner){
            imageAdapter = ImagesAdapter(it)
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.adapter = imageAdapter
            binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)

        }

        viewmModel.getAllImagesVM()


    }

}