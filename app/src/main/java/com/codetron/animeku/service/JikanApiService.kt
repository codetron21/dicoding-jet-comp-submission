package com.codetron.animeku.service

import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.data.response.WrapperResponse
import retrofit2.Response
import retrofit2.http.GET

interface JikanApiService {
    @GET("/v4/top/anime")
    //@GET("/top/anime")
    suspend fun getTopAnime(): Response<WrapperResponse<List<MovieItemResponse>>>
}