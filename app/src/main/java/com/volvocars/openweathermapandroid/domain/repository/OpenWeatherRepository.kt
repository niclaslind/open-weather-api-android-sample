package com.volvocars.openweathermapandroid.domain.repository

import com.volvocars.openweathermapandroid.domain.model.Weather

interface OpenWeatherRepository {
    suspend fun getWeatherByCityName(cityName: String): Result<Weather>
}