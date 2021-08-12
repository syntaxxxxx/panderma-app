package com.example.panderma.core.data.remote

import com.example.panderma.core.data.ResponseMovies
import com.example.panderma.core.data.api.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRemoteDataSourceImpl(
    private val apiService: ApiServices,
    private val refreshIntervalMs: Long = 10000L) {

    val movieUpcoming: Flow<ResponseMovies> = flow {
        while (true) {
            val movieUpcoming = apiService.getMovieUpcoming()
            emit(movieUpcoming)
            delay(refreshIntervalMs)
        }
    }.flowOn(Dispatchers.IO)

}