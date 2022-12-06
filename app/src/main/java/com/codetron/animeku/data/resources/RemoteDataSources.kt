package com.codetron.animeku.data.resources

import android.util.Log
import com.codetron.animeku.data.response.ErrorResponse
import com.codetron.animeku.data.response.HandleResponse
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.service.JikanApiService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
                val errorResponse = Gson().fromJson(
                    response.body()?.toString(),
                    TypeToken.get(ErrorResponse::class.java)
                )
                Log.d(TAG, errorResponse.message.toString())
                emit(HandleResponse(isError = true, errorMessage = errorResponse.message))
                return@flow
            }

            emit(HandleResponse(data = response.body()?.data ?: emptyList(), isError = false))
        }.catch {
            emit(HandleResponse(data = emptyList(), isError = true))
        }
    }

    companion object {
        private const val TAG = "RemoteDataSources"
    }

}