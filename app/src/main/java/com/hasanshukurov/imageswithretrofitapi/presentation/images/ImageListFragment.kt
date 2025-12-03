package com.hasanshukurov.imageswithretrofitapi.presentation.images

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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hasanshukurov.imageswithretrofitapi.databinding.FragmentImagesBinding
import com.hasanshukurov.imageswithretrofitapi.presentation.adapter.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * ImageListFragment - Şəkillər siyahısını göstərən fragment
 * 
 * Clean Architecture-da Fragment yalnız UI ilə məşğul olur
 * Business logic ViewModel-dədir
 */
@AndroidEntryPoint
class ImageListFragment : Fragment() {
    
    private var _binding: FragmentImagesBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: ImageListViewModel by viewModels()
    
    private lateinit var imageAdapter: ImageAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        observeState()
    }
    
    /**
     * RecyclerView-u qururuq
     */
    private fun setupRecyclerView() {
        imageAdapter = ImageAdapter { image ->
            // Şəkilə klikləndikdə detallar ekranına keçirik
            val action = ImageListFragmentDirections
                .actionImageListFragmentToImageDetailFragment(image.id)
            findNavController().navigate(action)
        }
        
        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
    
    /**
     * ViewModel state-ini müşahidə edirik
     */
    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    // Loading state
                    binding.progressBar.visibility = if (state.isLoading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                    
                    // Şəkillər siyahısı
                    imageAdapter.submitList(state.images)
                    
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


