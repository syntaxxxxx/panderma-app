package com.example.panderma.core.data.remote

import com.example.panderma.core.data.api.ApiService
import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import com.example.panderma.core.entity.ResponseDonorDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRemoteDataSourceImpl(private val apiService: ApiService) {

    val banner: Flow<ResponseBanner> = flow {
        val banner = apiService.getBanner()
        emit(banner)
    }.flowOn(Dispatchers.IO)

    val category: Flow<ResponseCategory> = flow {
        val category = apiService.getCategory()
        emit(category)
    }.flowOn(Dispatchers.IO)

    val donor: Flow<ResponseDonor> = flow {
        val donor = apiService.getDonor()
        emit(donor)
    }.flowOn(Dispatchers.IO)

    fun donorDetailsBy(donorId: Byte): Flow<ResponseDonorDetails> = flow {
        val donor = apiService.getDonorDetailsBy(donorId)
        emit(donor)
    }.flowOn(Dispatchers.IO)

}