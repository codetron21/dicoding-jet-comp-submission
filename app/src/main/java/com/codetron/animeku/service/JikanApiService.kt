package com.codetron.animeku.service

import com.codetron.animeku.data.response.MovieDetailResponse
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.data.response.WrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApiService {

    @GET("/v4/top/anime")
    suspend fun getTopAnime(): Response<WrapperResponse<List<MovieItemResponse>>>

    @GET("/v4/anime/{id}")
    suspend fun detailAnime(
        @Path("id") id: Int
    ): Response<WrapperResponse<MovieDetailResponse>>

}