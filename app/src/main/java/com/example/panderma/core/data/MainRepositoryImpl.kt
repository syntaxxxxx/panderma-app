package com.example.panderma.core.data

import com.example.panderma.core.data.remote.MainRemoteDataSourceImpl
import com.example.panderma.core.domain.MainRepository
import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(private val remoteDataSourceImpl: MainRemoteDataSourceImpl): MainRepository {

    override fun getBanner(): Flow<ResponseBanner> = remoteDataSourceImpl.banner
    override fun getCategory(): Flow<ResponseCategory> = remoteDataSourceImpl.category
    override fun getDonor(): Flow<ResponseDonor> = remoteDataSourceImpl.donor

}