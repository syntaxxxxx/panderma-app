package com.example.panderma.core.data.api

import com.example.panderma.BuildConfig
import com.example.panderma.core.data.ResponseMovies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/upcoming")
    suspend fun getMovieUpcoming(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): ResponseMovies

}