package com.volvocars.openweathermapandroid.data.remote

import com.volvocars.openweathermapandroid.data.remote.dto.WeatherResponseDto
import com.volvocars.openweathermapandroid.data.remote.service.OpenWeatherService
import com.volvocars.openweathermapandroid.data.util.HttpRoutes
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class OpenWeatherServiceImpl @Inject constructor(
    private val client: HttpClient
) : OpenWeatherService {
    override suspend fun getWeatherByCityName(cityName: String): Result<WeatherResponseDto> {
        return runCatching {
            client.get(HttpRoutes.WEATHER_URL) {
                parameter("q", cityName)
                parameter("appid", HttpRoutes.APP_ID)
                parameter("units", "metric")
            }
        }
    }

    companion object {
        val TAG = OpenWeatherServiceImpl::class.simpleName
    }
}