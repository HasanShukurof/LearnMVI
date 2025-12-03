package com.hasanshukurov.imageswithretrofitapi.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hasanshukurov.imageswithretrofitapi.databinding.FragmentImageDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * ImageDetailFragment - Şəkil detallarını göstərən fragment
 */
@AndroidEntryPoint
class ImageDetailFragment : Fragment() {
    
    private var _binding: FragmentImageDetailBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: ImageDetailViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        observeState()
    }
    
    /**
     * ViewModel state-ini müşahidə edirik
     */
    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    // Loading göstərmək üçün (lazım olsa əlavə edilə bilər)
                    
                    // Şəkil detallarını göstəririk
                    state.image?.let { image ->
                        Picasso.get()
                            .load(image.url)
                            .into(binding.detailImageView)
                        
                        binding.nameTextView.text = image.name
                        binding.captionsTextView.text = "Captions: ${image.captions}"
                        binding.boxcountTextView.text = "Box Count: ${image.boxCount}"
                        binding.heightTextView.text = "Height: ${image.height}px"
                    }
                    
                    // Error state
                    state.error?.let { error ->
                        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


