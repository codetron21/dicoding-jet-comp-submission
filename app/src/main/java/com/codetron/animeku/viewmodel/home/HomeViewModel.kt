package com.codetron.animeku.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codetron.animeku.data.model.MovieItem
import com.codetron.animeku.data.repository.IDataRepository
import com.codetron.animeku.data.response.MovieItemResponse
import com.codetron.animeku.extension.toDomain
import com.codetron.animeku.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: IDataRepository,
) : ViewModel() {

    private val _movies = MutableStateFlow<UiState<List<MovieItem>>>(UiState.Success(emptyList()))
    val movies: StateFlow<UiState<List<MovieItem>>> get() = _movies

    fun getTopMovies() = viewModelScope.launch {
        _movies.emit(UiState.Loading)
        repository.getTopMovies().collect { result ->
            result
                .onSuccess { list ->
                    val listMap = list.mapNotNull(MovieItemResponse::toDomain)
                    _movies.emit(UiState.Success(listMap))
                }
                .onFailure {
                    _movies.emit(UiState.Error(it))
                }
        }
    }

}