package com.codetron.animeku.ui

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    object Loading : UiState<Nothing>()
    data class Error(val exception: Throwable) : UiState<Nothing>()
}