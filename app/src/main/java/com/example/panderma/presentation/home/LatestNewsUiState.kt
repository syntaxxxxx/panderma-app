package com.example.panderma.presentation.home

import com.example.panderma.core.data.ResultsItem

sealed class LatestNewsUiState {
    data class Success(val news: List<ResultsItem>?): LatestNewsUiState()
    data class Error(val exception: Throwable): LatestNewsUiState()
}