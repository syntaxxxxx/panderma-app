package com.example.panderma.core.domain

import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getBanner(): Flow<ResponseBanner>
    fun getCategory(): Flow<ResponseCategory>
    fun getDonor(): Flow<ResponseDonor>
}