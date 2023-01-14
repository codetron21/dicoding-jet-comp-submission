package com.codetron.animeku.data.model

data class MovieDetail(
    val malId: Int,
    val title: String,
    val type: String,
    val episodes: Int,
    val members: Long,
    val score: Float,
    val image: String,
    val status: String,
    val aired: String,
    val duration: String,
    val rating: String,
    val scoredBy: Long,
    val rank: Int,
    val synopsis: String
)