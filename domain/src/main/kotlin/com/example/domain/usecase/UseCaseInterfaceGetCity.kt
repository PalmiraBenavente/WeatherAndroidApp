package com.example.domain.usecase

import com.example.domain.entities.ResponseWeatherInfo
import com.example.domain.utils.ServiceResult

interface UseCaseInterfaceGetCity {
    operator fun invoke(): ServiceResult<ResponseWeatherInfo>
}
