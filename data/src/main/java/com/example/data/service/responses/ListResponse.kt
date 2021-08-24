package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("dt")
    val date: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("main")
    val mainResponse: MainResponse = MainResponse(),

    @SerializedName("weather")
    val weatherResponse: List<WeatherResponse> = emptyList(),

    @SerializedName("clouds")
    val clouds: CloudResponse = CloudResponse(),

    @SerializedName("wind")
    val wind: WindResponse = WindResponse(),

    @SerializedName("visibility")
    val visibility: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("pop")
    val pop: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("rain")
    val rain: RainResponse = RainResponse(),

    @SerializedName("sys")
    val sys: SysResponse = SysResponse(),

    @SerializedName("dt_txt")
    val dtTxt: String = ConstantUtils.DEFAULT_STRING
)
