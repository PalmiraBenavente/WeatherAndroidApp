package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lat")
    val latitude: Double = ConstantUtils.DEFAULT_DOUBLE,

    @SerializedName("lon")
    val longitude: Double = ConstantUtils.DEFAULT_DOUBLE
)
