package com.codetron.animeku.data.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("mal_id")
    val malId: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("episodes")
    val episodes: Int? = null,
    @SerializedName("members")
    val members: Long? = null,
    @SerializedName("score")
    val score: Float? = null,
    @SerializedName("images")
    val images: MovieImageResponse? = null
)
