package com.example.di

import com.example.data.service.WeatherService
import com.example.domain.usecase.UseCaseInterfaceGetCity
import org.koin.dsl.module
import com.example.domain.service.WeatherInterfaceService
import com.example.domain.usecase.implement.UseCaseGetCity

val repositoriesModule = module {
    single<WeatherInterfaceService> { WeatherService() }
}
val useCasesModule = module {
    single<UseCaseInterfaceGetCity> { UseCaseGetCity() }
}
