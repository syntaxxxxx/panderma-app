package com.example.panderma.core.domain

import com.example.panderma.core.data.ResponseMovies
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getMovieUpcoming(): Flow<ResponseMovies>

}