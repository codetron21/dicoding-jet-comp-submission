package com.codetron.animeku.service

import com.codetron.animeku.data.response.MovieDetailResponse
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.data.response.WrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApiService {

    @GET("top/anime")
    suspend fun getTopAnime(): Response<WrapperResponse<List<MovieItemResponse>>>

    @GET("anime/{id}")
    suspend fun getDetailAnime(
        @Path("id") id: Int
    ): Response<WrapperResponse<MovieDetailResponse>>

    @GET("anime")
    suspend fun searchAnime(
        @Query("q") query: String
    ): Response<WrapperResponse<List<MovieItemResponse>>>

}