package com.example.data.database.entities

import com.example.data.Utils.ConstantUtils

data class ListDB(
    val dtTxt: String = ConstantUtils.DEFAULT_STRING,
    val date: Int = ConstantUtils.DEFAULT_INT,
    val mainResponse: MainTemperatureDB = MainTemperatureDB(),
    val weatherResponse: List<WeatherDescriptionDB> = emptyList(),
    val clouds: CloudDB = CloudDB(),
    val wind: WindDB = WindDB(),
    val visibility: Int = ConstantUtils.DEFAULT_INT,
    val pop: Double = ConstantUtils.DEFAULT_DOUBLE,
    val rain: RainDB = RainDB(),
    val sys: SysDB = SysDB(),
)
