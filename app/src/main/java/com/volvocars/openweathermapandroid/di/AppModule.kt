package com.volvocars.openweathermapandroid.di

import com.volvocars.openweathermapandroid.data.remote.service.OpenWeatherService
import com.volvocars.openweathermapandroid.data.repository.OpenWeatherRepositoryImpl
import com.volvocars.openweathermapandroid.domain.repository.OpenWeatherRepository
import com.volvocars.openweathermapandroid.domain.use_case.GetWeatherByCityName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenWeatherRepository(service: OpenWeatherService): OpenWeatherRepository =
        OpenWeatherRepositoryImpl(service)

    @Provides
    @Singleton
    fun provideFetchWeatherInCity(repository: OpenWeatherRepository) =
        GetWeatherByCityName(repository)
}