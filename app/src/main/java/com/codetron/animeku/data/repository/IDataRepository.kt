package com.codetron.animeku.data.repository

import com.codetron.animeku.data.response.MovieItemResponse
import kotlinx.coroutines.flow.Flow

interface IDataRepository {
    fun getTopMovies(): Flow<Result<List<MovieItemResponse>>>
}