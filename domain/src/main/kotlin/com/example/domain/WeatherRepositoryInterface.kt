package com.example.domain

import com.example.domain.entities.ResponseWeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepositoryInterface {
   fun getWeatherInformationToService()
   fun getWeatherInformationToDB() : Flow<ResponseWeatherInfo>
}
