package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")
    val speed: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("deg")
    val deg: Int = ConstantUtils.DEFAULT_INT,

    @SerializedName("gust")
    val gust: Double = ConstantUtils.DEFAULT_DOUBLE
)
