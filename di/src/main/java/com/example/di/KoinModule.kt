package com.example.di

import com.example.data.WeatherRepository
import com.example.data.database.WeatherDataBase
import com.example.data.database.WeatherDataBaseSource
import com.example.data.service.WeatherService
import com.example.domain.WeatherRepositoryInterface
import com.example.domain.usecase.WeatherUseCaseInterface
import com.example.domain.usecase.implement.WeatherUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single<WeatherUseCaseInterface> { WeatherUseCase(get()) }
}
val repositoryModule = module {
    factory { WeatherService() }
    single { WeatherDataBase.getInstance(get()) }
    single { get<WeatherDataBase>().weatherDao() }
    single { WeatherDataBaseSource(get()) }
    factory<WeatherRepositoryInterface> { WeatherRepository(get(), get()) }
}
