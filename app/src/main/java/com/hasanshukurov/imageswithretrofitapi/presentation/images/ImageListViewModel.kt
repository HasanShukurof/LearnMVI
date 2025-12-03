package com.hasanshukurov.imageswithretrofitapi.presentation.images

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.imageswithretrofitapi.domain.usecase.GetAllImagesUseCase
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * ImageListViewModel - Şəkillər siyahısı ekranının ViewModel-i
 * 
 * Clean Architecture-da ViewModel yalnız UseCase-lərlə işləyir
 * Repository-ni birbaşa çağırmır
 * 
 * StateFlow istifadə edirik ki, state management daha yaxşı olsun
 */
@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getAllImagesUseCase: GetAllImagesUseCase
) : ViewModel() {
    
    // Private mutable state
    private val _state = MutableStateFlow(ImageListState())
    
    // Public immutable state - UI buna subscribe olur
    val state: StateFlow<ImageListState> = _state.asStateFlow()
    
    init {
        // ViewModel yarananda avtomatik olaraq şəkilləri yükləyirik
        loadImages()
    }
    
    /**
     * UI-dan gələn event-ləri idarə edir
     */
    fun onEvent(event: ImageListEvent) {
        when (event) {
            is ImageListEvent.LoadImages -> loadImages()
            is ImageListEvent.RefreshImages -> loadImages()
        }
    }
    
    /**
     * Şəkilləri yükləyir
     */
    private fun loadImages() {
        getAllImagesUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true,
                        error = null
                    )
                }
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        images = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "Bilinməyən xəta"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}


