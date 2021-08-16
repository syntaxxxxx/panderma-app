package com.example.panderma.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panderma.core.domain.MainRepository
import com.example.panderma.core.ResultState
import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository): ViewModel() {

    private val _bannerResultState = MutableStateFlow<ResultState<ResponseBanner>>(ResultState.Idle())
    val bannerResultState: StateFlow<ResultState<ResponseBanner>> = _bannerResultState

    private val _categoryResultState = MutableStateFlow<ResultState<ResponseCategory>>(ResultState.Idle())
    val categoryResultState: StateFlow<ResultState<ResponseCategory>> = _categoryResultState

    private val _donorResultState = MutableStateFlow<ResultState<ResponseDonor>>(ResultState.Idle())
    val donorResultState: StateFlow<ResultState<ResponseDonor>> = _donorResultState

    init {
        getBanner()
        getCategory()
        getDonor()
    }

    private fun getBanner() {
        viewModelScope.launch {
            _bannerResultState.value = ResultState.ShowLoading()
            repository.getBanner()
                .catch { throwable ->
                    _bannerResultState.value = ResultState.Error(throwable)
                }
                .collect {
                    _bannerResultState.value = ResultState.Success(it)
                }
            _bannerResultState.value = ResultState.HideLoading()
        }
    }
    
    private fun getCategory() {
        viewModelScope.launch {
            _categoryResultState.value = ResultState.ShowLoading()
            repository.getCategory()
                .catch { throwable ->
                    _categoryResultState.value = ResultState.Error(throwable)
                }
                .collect {
                    _categoryResultState.value = ResultState.Success(it)
                }
            _categoryResultState.value = ResultState.HideLoading()
        }
    }

    private fun getDonor() {
        viewModelScope.launch {
            _donorResultState.value = ResultState.ShowLoading()
            repository.getDonor()
                .catch { throwable ->
                    _donorResultState.value = ResultState.Error(throwable)
                }
                .collect {
                    _donorResultState.value = ResultState.Success(it)
                }
            _donorResultState.value = ResultState.HideLoading()
        }
    }

}