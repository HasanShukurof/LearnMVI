package com.hasanshukurov.imageswithretrofitapi.view

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.hasanshukurov.imageswithretrofitapi.R
import com.hasanshukurov.imageswithretrofitapi.data.Images
import com.hasanshukurov.imageswithretrofitapi.databinding.FragmentImageDetailBinding
import com.squareup.picasso.Picasso


class ImageDetailFragment : Fragment() {
    private lateinit var binding: FragmentImageDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: ImageDetailFragmentArgs by navArgs()
        val gelenArgs = bundle.imageArgs

        Picasso.get().load(gelenArgs.url).into(binding.detailImageView)
        binding.nameTextView.text = gelenArgs.name
        binding.captionsTextView.text = gelenArgs.captions.toString()
        binding.boxcountTextView.text = gelenArgs.box_count.toString()
        binding.heightTextView.text = gelenArgs.height.toString()

    }


}