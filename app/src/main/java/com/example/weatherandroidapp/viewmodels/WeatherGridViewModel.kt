package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.usecase.WeatherUseCaseInterface

class WeatherGridViewModel(
    private val useCaseWeatherCity: WeatherUseCaseInterface
) : ViewModel() {
    private val weatherInfoLiveData: LiveData<ResponseWeatherInfo> = useCaseWeatherCity.observeWeather().asLiveData()

    fun getLiveDataWeatherInfo() = this.weatherInfoLiveData
}
