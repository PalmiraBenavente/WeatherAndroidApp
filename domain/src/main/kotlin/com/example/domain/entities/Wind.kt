package com.example.domain.entities

import com.example.domain.utils.DEFAULT_DOUBLE
import com.example.domain.utils.ZERO

data class Wind(
    val speed: Double = DEFAULT_DOUBLE,
    val deg: Int = ZERO,
    val gust: Double = DEFAULT_DOUBLE
)
