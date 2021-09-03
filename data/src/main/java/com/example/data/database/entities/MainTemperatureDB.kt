package com.example.data.database.entities

import com.example.data.Utils.ConstantUtils

data class MainTemperatureDB(
    val temperature: Double = ConstantUtils.DEFAULT_DOUBLE,
    val feelsLike: Double = ConstantUtils.DEFAULT_DOUBLE,
    val humidity: Int = ConstantUtils.DEFAULT_INT,
    val minimum: Double = ConstantUtils.DEFAULT_DOUBLE,
    val maximum: Double = ConstantUtils.DEFAULT_DOUBLE,
    val pressure: Int = ConstantUtils.DEFAULT_INT,
    val seaLevel: Int = ConstantUtils.DEFAULT_INT,
    val groundLevel: Int = ConstantUtils.DEFAULT_INT,
    val tempKf: Double = ConstantUtils.DEFAULT_DOUBLE
)
