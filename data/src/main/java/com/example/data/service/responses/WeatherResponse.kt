package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("main")
    val weather: String = ConstantUtils.DEFAULT_STRING,

    @SerializedName("description")
    val description: String = ConstantUtils.DEFAULT_STRING,

    @SerializedName("icon")
    val icon: String = ConstantUtils.DEFAULT_STRING
)
