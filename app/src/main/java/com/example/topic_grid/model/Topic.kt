package com.example.topic_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameId: Int,
    val id: Int,
    @DrawableRes val imageId: Int,
)