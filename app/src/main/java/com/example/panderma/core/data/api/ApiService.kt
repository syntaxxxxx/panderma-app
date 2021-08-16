package com.example.panderma.core.data.api

import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/general/banner")
    suspend fun getBanner(): ResponseBanner

    @GET("/api/general/category")
    suspend fun getCategory(): ResponseCategory

    @GET("/api/donor")
    suspend fun getDonor(
        @Query("type") type: String = "GIVER"
    ): ResponseDonor

}