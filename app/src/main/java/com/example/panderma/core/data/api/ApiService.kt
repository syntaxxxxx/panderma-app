package com.example.panderma.core.data.api

import com.example.panderma.core.entity.ResponseBanner
import com.example.panderma.core.entity.ResponseCategory
import com.example.panderma.core.entity.ResponseDonor
import com.example.panderma.core.entity.ResponseDonorDetails
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("/api/donor/detail/{donor_id}")
    suspend fun getDonorDetailsBy(
        @Path("donor_id") donorId: Byte
    ): ResponseDonorDetails

}