package com.example.panderma.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panderma.core.data.ResultsItem
import com.example.panderma.core.domain.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository): ViewModel() {

    private val _uiState = MutableStateFlow(LatestNewsUiState.Success(emptyList()))
    val uiState: StateFlow<LatestNewsUiState> = _uiState

    init {
        viewModelScope.launch {
            repository.getMovieUpcoming().collect {
                _uiState.value = LatestNewsUiState.Success(it.results)
            }
        }
    }

}