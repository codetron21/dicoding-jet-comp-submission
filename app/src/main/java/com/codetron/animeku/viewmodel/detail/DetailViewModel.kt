package com.codetron.animeku.viewmodel.detail

import androidx.lifecycle.ViewModel
import com.codetron.animeku.data.model.MovieDetail
import com.codetron.animeku.data.repository.IDataRepository
import com.codetron.animeku.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel(
    private val repository: IDataRepository,
) : ViewModel() {

    private val _movie = MutableStateFlow<UiState<MovieDetail>>(UiState.Loading)
    val movie: StateFlow<UiState<MovieDetail>> get() = _movie

    fun getMovie(id: Int) {
        _movie.value = UiState.Loading

    }

}