package com.example.domain.entities

import com.example.domain.utils.DEFAULT_DOUBLE
import com.example.domain.utils.NOT_FOUND
import com.example.domain.utils.ZERO

data class ListWeather(
    val date: Int = ZERO,
    val mainResponse: MainWeather = MainWeather(),
    val weatherResponse: List<WeatherDescription> = emptyList(),
    val clouds: Cloud = Cloud(),
    val wind: Wind = Wind(),
    val visibility: Int = ZERO,
    val pop: Double = DEFAULT_DOUBLE,
    val rain: Rain = Rain(),
    val sys: Sys = Sys(),
    val dtTxt: String = NOT_FOUND
)
