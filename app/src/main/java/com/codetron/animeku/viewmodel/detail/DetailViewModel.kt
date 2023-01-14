package com.codetron.animeku.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codetron.animeku.data.model.MovieDetail
import com.codetron.animeku.data.repository.IDataRepository
import com.codetron.animeku.extension.toDomain
import com.codetron.animeku.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: IDataRepository,
) : ViewModel() {

    private val _movie = MutableStateFlow<UiState<MovieDetail>>(UiState.Loading)
    val movie: StateFlow<UiState<MovieDetail>> get() = _movie

    fun getMovie(id: Int?) = viewModelScope.launch {
        _movie.value = UiState.Loading

        if (id == null) {
            _movie.value = UiState.Error(Exception())
            return@launch
        }

        repository.getDetailMovie(id).collect { result ->
            result
                .onSuccess {
                    val data = it.toDomain()
                    if (data != null) {
                        _movie.value = UiState.Success(data)
                    } else {
                        _movie.value = UiState.Error(Exception())
                    }
                }
                .onFailure {
                    _movie.value = UiState.Error(it)
                }
        }
    }

}