package com.example.data.database

import com.example.data.database.entities.WeatherInformationDB
import kotlinx.coroutines.flow.Flow

class WeatherDataBaseSource(private val weatherDataBase: WeatherDataBase) {

    fun insertWeatherInformation(weatherInformationDB: WeatherInformationDB) {
        weatherDataBase.weatherDao().insertWeatherInformation(weatherInformationDB)
    }

    fun getWeatherInformation(): Flow<WeatherInformationDB> = weatherDataBase.weatherDao().getWeather()
}
