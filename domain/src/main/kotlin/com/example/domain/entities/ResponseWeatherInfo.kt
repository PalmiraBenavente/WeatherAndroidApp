package com.example.domain.entities

import com.example.domain.utils.NOT_FOUND
import com.example.domain.utils.ZERO

data class ResponseWeatherInfo(
    val cod: String = NOT_FOUND,
    val message: Int? = ZERO,
    val cnt: Int? = ZERO,
    val list: List<ListWeather>? = listOf(),
)
