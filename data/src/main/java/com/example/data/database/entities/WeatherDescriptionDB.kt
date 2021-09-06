package com.example.data.database.entities

import com.example.data.Utils.ConstantUtils

data class WeatherDescriptionDB(
    val id: Int = ConstantUtils.DEFAULT_INT,
    val weather: String = ConstantUtils.DEFAULT_STRING,
    val description: String = ConstantUtils.DEFAULT_STRING,
    val icon: String = ConstantUtils.DEFAULT_STRING
)
