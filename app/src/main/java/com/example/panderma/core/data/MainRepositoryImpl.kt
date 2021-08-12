package com.example.panderma.core.data

import com.example.panderma.core.data.remote.MainRemoteDataSourceImpl
import com.example.panderma.core.domain.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(private val remoteDataSourceImpl: MainRemoteDataSourceImpl): MainRepository {

    override fun getMovieUpcoming(): Flow<ResponseMovies> = remoteDataSourceImpl.movieUpcoming

}