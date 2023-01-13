package com.codetron.animeku.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Profile(
    @StringRes val nameRes: Int,
    @StringRes val emailRes: Int,
    @DrawableRes val photoRes: Int,
)