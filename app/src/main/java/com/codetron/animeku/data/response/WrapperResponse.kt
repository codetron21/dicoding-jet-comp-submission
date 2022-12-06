package com.codetron.animeku.data.response

import com.google.gson.annotations.SerializedName

data class WrapperResponse<T>(
    @SerializedName("data")
    val data: T
)