package com.example.data.service

import com.example.data.BuildConfig
import com.example.data.service.responses.ResponseApi
import com.example.domain.utils.ServiceResult

class WeatherService {

    private val generator = WeatherServiceRequest()

    fun getWeatherCityInfoToService(): ServiceResult<ResponseApi> {
        val callResponse = generator.createService(WeatherApi::class.java).callWeatherInfo(CITY, BuildConfig.ApiKey, UNITS)
        return try {
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { ServiceResult.Success(it) }
            }
            ServiceResult.Failure(Exception(response.message()))
        } catch (e: Exception) {
            ServiceResult.Failure(Exception(e.message))
        }
    }

    companion object {
        private const val CITY: String = "Tandil"
        private const val UNITS: String = "metric"
    }
}
