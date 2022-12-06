package com.codetron.animeku.data.response

import com.google.gson.annotations.SerializedName

data class MovieItemResponse(
    @SerializedName("mal_id")
    val malId: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("episodes")
    val episodes: Int? = null,
    @SerializedName("members")
    val members: Long?=null,
    @SerializedName("score")
    val score: Float?=null,
    @SerializedName("images")
    val images: MovieImageResponse? = null
)

data class MovieImageResponse(
    @SerializedName("jpg")
    val jpg: MovieImageSizeResponse
)

data class MovieImageSizeResponse(
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("small_image_url")
    val smallImageUrl: String? = null,
    @SerializedName("large_image_url")
    val largeImageUrl: String? = null
)