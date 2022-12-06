package com.codetron.animeku.data.repository

import com.codetron.animeku.data.resources.IRemoteDataSources
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.extension.toResult
import kotlinx.coroutines.flow.Flow

class DataRepository(
    private val sources: IRemoteDataSources
) : IDataRepository {

    override fun getTopMovies(): Flow<Result<List<MovieItemResponse>>> {
        return sources.getTopMovies().toResult()
    }
}