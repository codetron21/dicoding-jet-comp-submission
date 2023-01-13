package com.codetron.animeku.data.resources

import com.codetron.animeku.data.response.HandleResponse
import com.codetron.animeku.data.response.MovieDetailResponse
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.extension.getErrorResponse
import com.codetron.animeku.service.JikanApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class RemoteDataSources(
    private val service: JikanApiService
) : IRemoteDataSources {

    override fun getTopMovies(): Flow<HandleResponse<List<MovieItemResponse>>> {
        return flow {
            val response = service.getTopAnime()

            if (!response.isSuccessful) {
                val errorResponse = response.errorBody().getErrorResponse()
                emit(HandleResponse(isError = true, errorMessage = errorResponse.message))
                return@flow
            }

            emit(HandleResponse(data = response.body()?.data ?: emptyList(), isError = false))
        }.catch {
            emit(HandleResponse(data = emptyList(), isError = true))
        }
    }

    override fun getDetailMovie(id: Int): Flow<HandleResponse<MovieDetailResponse>> {
        return flow {  }
    }
}