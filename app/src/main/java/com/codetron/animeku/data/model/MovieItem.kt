package com.codetron.animeku.data.model

data class MovieItem(
    val id: Int,
    val title: String,
    val type: String,
    val episodes: Int,
    val members: Long,
    val score: Float,
    val image: String? = null,
)