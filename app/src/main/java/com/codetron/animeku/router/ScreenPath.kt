package com.codetron.animeku.router

object ScreenPath {
    const val splash = "/splash"
    const val home = "/home"
    const val search = "/search"
    const val detailWithKeys = "/detail/{${Keys.id}}"
    const val detail = "/detail"
    const val about = "/about"

    object Keys {
        const val id = "id"
    }

    fun addBackSlash(input: String): String {
        return "/$input"
    }

}