package com.example.data.service

import com.example.data.BuildConfig
import com.example.data.WeatherServiceRequest
import com.example.data.mappers.transformApi
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.service.WeatherInterfaceService
import com.example.domain.utils.ServiceResult

class WeatherService : WeatherInterfaceService {

    private val generator = WeatherServiceRequest()

    override fun getWeatherCityInfo(): ServiceResult<ResponseWeatherInfo> {
        val callResponse =
            generator.createService(WeatherApi::class.java).callWeatherInfo(CITY, BuildConfig.ApiKey, UNITS)
        try {
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.transformApi()?.let { return ServiceResult.Success(it) }
            }
            return ServiceResult.Failure(Exception(response.message()))
        } catch (e: Exception) {
            return ServiceResult.Failure(Exception(e.message))
        }
    }

    companion object {
        private const val CITY: String = "Tandil"
        private const val UNITS: String = "metric"
    }
}
