package com.volvocars.openweathermapandroid.data.repository

import com.volvocars.openweathermapandroid.data.remote.service.OpenWeatherService
import com.volvocars.openweathermapandroid.data.util.HttpRoutes
import com.volvocars.openweathermapandroid.domain.model.Weather
import com.volvocars.openweathermapandroid.domain.repository.OpenWeatherRepository
import javax.inject.Inject
import kotlin.math.roundToInt

class OpenWeatherRepositoryImpl @Inject constructor(
    private val service: OpenWeatherService
) : OpenWeatherRepository {
    override suspend fun getWeatherByCityName(cityName: String): Result<Weather> {
        return service.getWeatherByCityName(cityName).mapCatching {
            Weather(
                name = it.name,
                temp = it.main.temp.roundToInt(),
                humidity = it.main.humidity.roundToInt(),
                windDirection = it.wind.deg.roundToInt(),
                windSpeed = it.wind.speed.roundToInt(),
                pressure = it.main.pressure.roundToInt(),
                iconUrl = if (it.weather.isNotEmpty()) {
                    "${HttpRoutes.ICON_URL}/${it.weather[0].icon}@2x.png"
                } else {
                    null
                }
            )
        }
    }

    companion object {
        val TAG = OpenWeatherRepositoryImpl::class.simpleName
    }
}