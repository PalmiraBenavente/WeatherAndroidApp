package com.example.domain.usecase

import com.example.domain.entities.ResponseWeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherUseCaseInterface {
    fun observeWeather() : Flow<ResponseWeatherInfo>
    operator fun invoke()
}
