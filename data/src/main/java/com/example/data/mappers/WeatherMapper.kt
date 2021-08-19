package com.example.data.mappers

import com.example.data.service.responses.CloudResponse
import com.example.data.service.responses.WeatherResponse
import com.example.data.service.responses.MainResponse
import com.example.data.service.responses.ListResponse
import com.example.data.service.responses.ResponseApi
import com.example.data.service.responses.CityResponse
import com.example.data.service.responses.CoordResponse
import com.example.data.service.responses.RainResponse
import com.example.data.service.responses.SysResponse
import com.example.data.service.responses.WindResponse
import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.entities.MainWeather
import com.example.domain.entities.City
import com.example.domain.entities.Cloud
import com.example.domain.entities.Coordinates
import com.example.domain.entities.ListWeather
import com.example.domain.entities.Rain
import com.example.domain.entities.Sys
import com.example.domain.entities.Wind
import com.example.domain.entities.WeatherDescription

fun ResponseApi.transformApi() = ResponseWeatherInfo(
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.list.transformList(),
    city = this.city.transformCity()
)

private fun CityResponse.transformCity() = City(
    id = this.id,
    name = this.name,
    coord = this.coordinates.transformCoord(),
    country = this.country,
    population = this.population,
    timezone = this.timezone,
    sunrise = this.sunrise,
    sunset = this.sunset
)

private fun List<ListResponse>.transformList() = this.map { it.transformListData() }

private fun ListResponse.transformListData() = ListWeather(
    date = this.date,
    mainResponse = this.mainResponse.transformMain(),
    weatherResponse = this.weatherResponse.map { it.transformDescription() },
    clouds = this.clouds.transformCloud(),
    wind = this.wind.transformWind(),
    visibility = this.visibility,
    pop = this.pop,
    rain = this.rain.transformRain(),
    sys = this.sys.transformSys(),
    dtTxt = this.dtTxt
)

private fun MainResponse.transformMain() = MainWeather(
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

private fun WeatherResponse.transformDescription() = WeatherDescription(
    id = this.id,
    weather = this.weather,
    description = this.description,
    icon = this.icon
)

private fun CloudResponse.transformCloud() = Cloud(cloudiness = this.cloudiness)

private fun WindResponse.transformWind() = Wind(speed = this.speed, deg = this.deg, gust = this.gust)

private fun RainResponse.transformRain() = Rain(rainVolume = this.rainVolume)

private fun SysResponse.transformSys() = Sys(pod = this.pod)

private fun CoordResponse.transformCoord() = Coordinates(lat = this.latitude, lon = this.longitude)
