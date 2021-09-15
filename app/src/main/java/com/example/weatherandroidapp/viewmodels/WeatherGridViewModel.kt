package com.example.weatherandroidapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.usecase.WeatherUseCaseInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherGridViewModel(
    private val useCaseWeatherCity: WeatherUseCaseInterface
) : ViewModel() {
    private val _weatherInfoLiveData = MutableLiveData<ResponseWeatherInfo>()
    val weatherInfoLiveData = useCaseWeatherCity.observeWeather().asLiveData()

    fun getWeather() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) { useCaseWeatherCity.invoke() }
        }
    }

    fun updateWeatherList(responseWeatherInfo: ResponseWeatherInfo) = viewModelScope.launch {
        with(responseWeatherInfo) {
            oldScreenOrNew.copy(this.cod, this.message, this.cnt, this.list)
        }
        _weatherInfoLiveData.value = oldScreenOrNew
    }

    private val oldScreenOrNew
        get() = _weatherInfoLiveData.value ?: ResponseWeatherInfo()
}
