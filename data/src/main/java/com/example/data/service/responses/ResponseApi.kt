package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("cod")
    val cod: String = ConstantUtils.DEFAULT_STRING,

    @SerializedName("message")
    val message: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("cnt")
    val cnt: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("list")
    val list: List<ListResponse> = emptyList(),

    @SerializedName("city")
    val city: CityResponse = CityResponse()
)
