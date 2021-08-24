package com.example.data.service.responses

import com.example.data.Utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class SysResponse(
    @SerializedName("pod")
    val pod: String = ConstantUtils.DEFAULT_STRING
)
