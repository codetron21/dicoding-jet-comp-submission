package com.codetron.animeku.extension

import com.codetron.animeku.data.model.MovieItem
import com.codetron.animeku.data.response.ErrorResponse
import com.codetron.animeku.data.response.HandleResponse
import com.codetron.animeku.data.response.MovieItemResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody

fun <T> Flow<HandleResponse<T>>.toResult(): Flow<Result<T>> {
    return flow {
        val response = this@toResult.first()
        if (!response.isError) {
            val data = response.data
            if (data == null) {
                emit(Result.failure(Exception()))
            } else {
                emit(Result.success(data))
            }
        } else {
            emit(Result.failure(Exception(response.errorMessage)))
        }
    }
}

fun ResponseBody?.getErrorResponse():ErrorResponse{
   return Gson().fromJson(
       this?.string(),
        TypeToken.get(ErrorResponse::class.java)
    )
}

fun MovieItemResponse.toDomain(): MovieItem? {
    if (this.malId == null) return null

    return MovieItem(
        id = this.malId,
        title = this.title.orEmpty(),
        type = this.type.orEmpty(),
        episodes = this.episodes ?: 0,
        members = this.members ?: 0,
        score = this.score ?: 0F,
        image = this.images?.jpg?.imageUrl,
    )
}