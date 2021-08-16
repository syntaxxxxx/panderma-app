package com.example.panderma.presentation.home.list.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panderma.core.ResultState
import com.example.panderma.core.domain.MainRepository
import com.example.panderma.core.entity.ResponseDonorDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListDetailsViewModel(private val repository: MainRepository): ViewModel() {

    private val _donorDetailsResultState = MutableStateFlow<ResultState<ResponseDonorDetails>>(ResultState.Idle())
    val donorDetailsResultState: StateFlow<ResultState<ResponseDonorDetails>> = _donorDetailsResultState

    fun getDonorDetailsBy(donorId: Byte) {
        viewModelScope.launch {
            _donorDetailsResultState.value = ResultState.ShowLoading()
            repository.getDonorDetails(donorId)
                .catch { throwable ->
                    _donorDetailsResultState.value = ResultState.Error(throwable)
                }
                .collect {
                    _donorDetailsResultState.value = ResultState.Success(it)
                }
            _donorDetailsResultState.value = ResultState.HideLoading()
        }
    }


}