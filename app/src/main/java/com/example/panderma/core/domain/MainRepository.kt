package com.example.panderma.core.domain

import com.example.panderma.core.entity.*
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getBanner(): Flow<ResponseBanner>
    fun getCategory(): Flow<ResponseCategory>
    fun getDonor(): Flow<ResponseDonor>
    fun getDonorDetails(donorId: Byte): Flow<ResponseDonorDetails>
}