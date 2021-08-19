package com.example.domain.usecase.implement

import com.example.domain.service.WeatherInterfaceService
import com.example.domain.usecase.UseCaseInterfaceGetCity
import org.koin.core.KoinComponent
import org.koin.core.inject

class UseCaseGetCity() : KoinComponent, UseCaseInterfaceGetCity {

    private val weatherWeatherInterfaceService: WeatherInterfaceService by inject()

    override fun invoke() = weatherWeatherInterfaceService.getWeatherCityInfo()
}
