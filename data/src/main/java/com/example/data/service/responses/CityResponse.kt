package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("name")
    val name: String = ConstantUtils.DEFAULT_STRING,

    @SerializedName("coord")
    val coordinates: CoordResponse = CoordResponse(),

    @SerializedName("country")
    val country: String = ConstantUtils.DEFAULT_STRING,

    @SerializedName("population")
    val population: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("timezone")
    val timezone: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("sunrise")
    val sunrise: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("sunset")
    val sunset: Int = ConstantUtils.DEFAULT_INT
)
