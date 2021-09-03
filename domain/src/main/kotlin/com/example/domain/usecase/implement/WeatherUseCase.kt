package com.example.domain.usecase.implement

import com.example.domain.WeatherRepositoryInterface
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.usecase.WeatherUseCaseInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent

class WeatherUseCase(
    private val weatherRepository: WeatherRepositoryInterface
) : KoinComponent, WeatherUseCaseInterface {

    override fun observeWeather(): Flow<ResponseWeatherInfo> = weatherRepository.getWeatherInformationToDB()

    override fun invoke() {
        weatherRepository.getWeatherInformationToService()
    }
}
