package com.example.topic_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// model with image, int, and name of topic
data class Topic(
    @StringRes val nameId: Int,
    val id: Int,
    @DrawableRes val imageId: Int,
)