package com.hasanshukurov.imageswithretrofitapi.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.imageswithretrofitapi.domain.usecase.GetImageByIdUseCase
import com.hasanshukurov.imageswithretrofitapi.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ImageDetailViewModel - Şəkil detalları ekranının ViewModel-i
 * 
 * SavedStateHandle istifadə edirik ki, navigation argument-ləri əldə edək
 */
@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    private val getImageByIdUseCase: GetImageByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    
    private val _state = MutableStateFlow(ImageDetailState())
    val state: StateFlow<ImageDetailState> = _state.asStateFlow()
    
    init {
        // Navigation argument-dən image ID-ni alırıq
        savedStateHandle.get<String>("imageId")?.let { imageId ->
            loadImage(imageId)
        }
    }
    
    /**
     * ID-yə görə şəkil yükləyir
     */
    private fun loadImage(imageId: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            
            when (val result = getImageByIdUseCase(imageId)) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        image = result.data,
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
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }
    }
}


