package com.example.data.mappers

import com.example.data.database.entities.ListDB
import com.example.data.database.entities.WeatherInformationDB
import com.example.data.database.entities.MainTemperatureDB
import com.example.data.database.entities.WeatherDescriptionDB
import com.example.data.database.entities.CloudDB
import com.example.data.database.entities.SysDB
import com.example.data.database.entities.RainDB
import com.example.data.database.entities.WindDB
import com.example.data.service.responses.ListResponse
import com.example.data.service.responses.ResponseApi
import com.example.data.service.responses.MainResponse
import com.example.data.service.responses.WeatherResponse
import com.example.data.service.responses.CloudResponse
import com.example.data.service.responses.SysResponse
import com.example.data.service.responses.RainResponse
import com.example.data.service.responses.WindResponse

fun ResponseApi.transformApiToDB() = WeatherInformationDB(
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    listWeather = this.list.transformListToDB(),
)

private fun List<ListResponse>.transformListToDB() = this.map { it.transformListDataToDB() }

private fun ListResponse.transformListDataToDB() = ListDB(
    date = this.date,
    mainResponse = this.mainResponse.transformMainToDB(),
    weatherResponse = this.weatherResponse.map { it.transformDescriptionToDB() },
    clouds = this.clouds.transformCloudToDB(),
    wind = this.wind.transformWindToDB(),
    visibility = this.visibility,
    pop = this.pop,
    rain = this.rain.transformRainToDB(),
    sys = this.sys.transformSysToDB(),
    dtTxt = this.dtTxt
)

private fun MainResponse.transformMainToDB() = MainTemperatureDB(
    temperature = this.temperature,
    feelsLike = this.feelsLike,
    minimum = this.minimum,
    maximum = this.maximum,
    pressure = this.pressure,
    seaLevel = this.seaLevel,
    groundLevel = this.groundLevel,
    humidity = this.humidity,
    tempKf = this.tempKf
)

private fun WeatherResponse.transformDescriptionToDB() = WeatherDescriptionDB(
    id = this.id,
    weather = this.weather,
    description = this.description,
    icon = this.icon
)

private fun CloudResponse.transformCloudToDB() = CloudDB(cloudiness = this.cloudiness)

private fun WindResponse.transformWindToDB() = WindDB(speed = this.speed, deg = this.deg, gust = this.gust)

private fun RainResponse.transformRainToDB() = RainDB(rainVolume = this.rainVolume)

private fun SysResponse.transformSysToDB() = SysDB(pod = this.pod)
