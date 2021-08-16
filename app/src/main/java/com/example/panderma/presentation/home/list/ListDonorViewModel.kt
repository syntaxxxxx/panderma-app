package com.example.panderma.presentation.home.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panderma.core.ResultState
import com.example.panderma.core.domain.MainRepository
import com.example.panderma.core.entity.ResponseDonor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListDonorViewModel(private val repository: MainRepository): ViewModel() {

    private val _donorResultState = MutableStateFlow<ResultState<ResponseDonor>>(ResultState.Idle())
    val donorResultState: StateFlow<ResultState<ResponseDonor>> = _donorResultState

    init {
        getDonor()
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