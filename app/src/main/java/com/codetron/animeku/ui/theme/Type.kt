package com.codetron.animeku.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codetron.animeku.R

val Fredoka = FontFamily(
    Font(R.font.fredoka_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h5 = TextStyle(
        fontFamily = Fredoka,
        fontSize = 24.sp,
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Black,
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Grey,
    ),
    button = TextStyle(
        fontFamily = Fredoka,
        fontSize = 14.sp,
    ),
)