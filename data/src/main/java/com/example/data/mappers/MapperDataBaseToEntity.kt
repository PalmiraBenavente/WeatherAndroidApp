package com.example.data.mappers

import com.example.data.Utils.ConstantUtils.DEFAULT_STRING
import com.example.data.database.entities.ListDB
import com.example.data.database.entities.WeatherInformationDB
import com.example.data.database.entities.MainTemperatureDB
import com.example.data.database.entities.WeatherDescriptionDB
import com.example.data.database.entities.CloudDB
import com.example.data.database.entities.SysDB
import com.example.data.database.entities.RainDB
import com.example.data.database.entities.WindDB
import com.example.domain.entities.ListWeather
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.entities.MainWeather
import com.example.domain.entities.WeatherDescription
import com.example.domain.entities.Cloud
import com.example.domain.entities.Sys
import com.example.domain.entities.Rain
import com.example.domain.entities.Wind

fun WeatherInformationDB?.transformBDToEntity() = ResponseWeatherInfo(
    cod = this?.cod ?: DEFAULT_STRING,
    message = this?.message,
    cnt = this?.cnt,
    list = this?.listWeather?.transformListToEntity(),
)

private fun List<ListDB>.transformListToEntity() = this.map { it.transformListDataToEntity() }

private fun ListDB.transformListDataToEntity() = ListWeather(
    date = this.date,
    mainResponse = this.mainResponse.transformMainToEntity(),
    weatherResponse = this.weatherResponse.map { it.transformDescriptionToEntity() },
    clouds = this.clouds.transformCloudToEntity(),
    wind = this.wind.transformWindToEntity(),
    visibility = this.visibility,
    pop = this.pop,
    rain = this.rain.transformRainToEntity(),
    sys = this.sys.transformSysToEntity(),
    dtTxt = this.dtTxt
)

private fun MainTemperatureDB.transformMainToEntity() = MainWeather(
    temperature = this.temperature,
    feelsLike = this.feelsLike,
    min = this.minimum,
    max = this.maximum,
    pressure = this.pressure,
    seaLevel = this.seaLevel,
    groundLevel = this.groundLevel,
    humidity = this.humidity,
    tempKf = this.tempKf
)

private fun WeatherDescriptionDB.transformDescriptionToEntity() = WeatherDescription(
    id = this.id,
    weather = this.weather,
    description = this.description,
    icon = this.icon
)

private fun CloudDB.transformCloudToEntity() = Cloud(cloudiness = this.cloudiness)

private fun WindDB.transformWindToEntity() = Wind(speed = this.speed, deg = this.deg, gust = this.gust)

private fun RainDB.transformRainToEntity() = Rain(rainVolume = this.rainVolume)

private fun SysDB.transformSysToEntity() = Sys(pod = this.pod)
