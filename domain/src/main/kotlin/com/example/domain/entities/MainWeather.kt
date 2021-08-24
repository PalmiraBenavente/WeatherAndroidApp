package com.example.domain.entities

import com.example.domain.utils.DEFAULT_DOUBLE
import com.example.domain.utils.DEFAULT_TEMP
import com.example.domain.utils.ZERO

data class MainWeather(
    val temperature: Double = DEFAULT_TEMP,
    val feelsLike: Double = DEFAULT_TEMP,
    val min: Double = DEFAULT_TEMP,
    val max: Double = DEFAULT_TEMP,
    val pressure: Int = ZERO,
    val humidity: Int = ZERO,
    val seaLevel: Int = ZERO,
    val groundLevel: Int = ZERO,
    val tempKf: Double = DEFAULT_DOUBLE
)


