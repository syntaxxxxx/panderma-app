package com.example.panderma.core.data

import com.example.panderma.core.data.remote.MainRemoteDataSourceImpl
import com.example.panderma.core.domain.MainRepository

class MainRepositoryImpl(private val remoteDataSourceImpl: MainRemoteDataSourceImpl): MainRepository {
}