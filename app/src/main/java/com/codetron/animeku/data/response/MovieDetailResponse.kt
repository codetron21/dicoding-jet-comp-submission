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
    val images: MovieImageResponse? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("aired")
    val aired: AiredResponse? = null,
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("scored_by")
    val scoredBy: Long? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("synopsis")
    val synopsis: String? = null
)

data class AiredResponse(
    @SerializedName("from") val from: String? = null,
    @SerializedName("to") val to: String? = null,
) {
    override fun toString(): String {
        return "$from,$to"
    }
}
