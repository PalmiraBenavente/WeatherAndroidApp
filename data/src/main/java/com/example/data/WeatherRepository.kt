package com.example.data

import com.example.data.database.WeatherDataBaseSource
import com.example.data.mappers.transformApiToDB
import com.example.data.mappers.transformBDToEntity
import com.example.data.service.WeatherService
import com.example.data.service.responses.ResponseApi
import com.example.domain.WeatherRepositoryInterface
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDataBaseSource: WeatherDataBaseSource
) : WeatherRepositoryInterface {

    override fun getWeatherInformationToDB(): Flow<ResponseWeatherInfo> =
        weatherDataBaseSource.getWeatherInformation().map { it.transformBDToEntity() }

    override fun getWeatherInformationToService() {
        with(weatherService.getWeatherCityInfoToService()) {
            when (this) {
                is ServiceResult.Success -> { insertWeatherIntoDB(this.data) }
                is ServiceResult.Failure -> { Exception(this.exception) }
            }
        }
    }

    private fun insertWeatherIntoDB(responseApi: ResponseApi) {
        weatherDataBaseSource.insertWeatherInformation(responseApi.transformApiToDB())
    }
}
