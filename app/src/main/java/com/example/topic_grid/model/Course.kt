package com.example.topic_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(

    @DrawableRes val image: Int,
    @StringRes val name: Int,
    val id: Int,
)