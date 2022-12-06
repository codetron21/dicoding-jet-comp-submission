package com.codetron.animeku.data.response

data class HandleResponse<T>(
    val data: T? = null,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)