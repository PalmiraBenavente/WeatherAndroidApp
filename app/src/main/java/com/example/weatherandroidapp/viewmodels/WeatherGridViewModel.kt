package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.WeatherUseCaseInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherGridViewModel(
    private val useCaseWeatherCity: WeatherUseCaseInterface
) : ViewModel() {
    val weatherInfoLiveData = useCaseWeatherCity.observeWeather().asLiveData()

    fun getWeather() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) { useCaseWeatherCity.invoke() }
        }
    }
}
