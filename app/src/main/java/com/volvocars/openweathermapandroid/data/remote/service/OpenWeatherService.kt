package com.volvocars.openweathermapandroid.data.remote.service

import com.volvocars.openweathermapandroid.data.remote.dto.WeatherResponseDto
import com.volvocars.openweathermapandroid.domain.model.City

interface OpenWeatherService {
    suspend fun getWeatherByCityName(cityName: String): Result<WeatherResponseDto>
}