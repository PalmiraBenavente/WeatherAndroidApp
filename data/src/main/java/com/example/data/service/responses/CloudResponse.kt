package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CloudResponse(
    @SerializedName("all")
    val cloudiness: Int = ConstantUtils.DEFAULT_INT
)
