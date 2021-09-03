package com.example.data.database.entities

import com.example.data.Utils.ConstantUtils

data class WindDB(
    val speed: Double = ConstantUtils.DEFAULT_DOUBLE,
    val deg: Int = ConstantUtils.DEFAULT_INT,
    val gust: Double = ConstantUtils.DEFAULT_DOUBLE
)
