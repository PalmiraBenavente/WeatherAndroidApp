package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class RainResponse(
    @SerializedName("3h")
    val rainVolume: Double = ConstantUtils.DEFAULT_DOUBLE
)
