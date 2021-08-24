package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("temp")
    val temperature: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("feels_like")
    val feelsLike: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("temp_min")
    val minimum: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("temp_max")
    val maximum: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("pressure")
    val pressure: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("sea_level")
    val seaLevel: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("ground_level")
    val groundLevel: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("humidity")
    val humidity: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("temp_kf")
    val tempKf: Double = ConstantUtils.DEFAULT_DOUBLE
)
