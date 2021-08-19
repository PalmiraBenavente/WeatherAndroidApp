package com.example.domain.service

import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.utils.ServiceResult

interface WeatherInterfaceService {
    fun getWeatherCityInfo(): ServiceResult<ResponseWeatherInfo>
}
