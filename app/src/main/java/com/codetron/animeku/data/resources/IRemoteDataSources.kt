package com.codetron.animeku.data.resources

import com.codetron.animeku.data.response.HandleResponse
import com.codetron.animeku.data.response.MovieDetailResponse
import com.codetron.animeku.data.response.MovieItemResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSources {

    fun getTopMovies(): Flow<HandleResponse<List<MovieItemResponse>>>

    fun getDetailMovie(id: Int): Flow<HandleResponse<MovieDetailResponse>>

    fun searchMovies(query:String?):Flow<HandleResponse<List<MovieItemResponse>>>

}