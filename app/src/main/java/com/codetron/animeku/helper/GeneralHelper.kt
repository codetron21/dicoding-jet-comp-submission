package com.codetron.animeku.helper

import java.text.SimpleDateFormat
import java.util.*

object GeneralHelper {

    fun formatDateStr(dateStr: String): String? {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = sdf.parse(dateStr)
        return date?.let { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(it) }
    }

}