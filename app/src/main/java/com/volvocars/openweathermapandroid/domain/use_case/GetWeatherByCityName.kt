package com.volvocars.openweathermapandroid.domain.use_case

import com.volvocars.openweathermapandroid.domain.model.City
import com.volvocars.openweathermapandroid.domain.model.Weather
import com.volvocars.openweathermapandroid.domain.repository.OpenWeatherRepository
import com.volvocars.openweathermapandroid.domain.util.toCityName
import javax.inject.Inject

class GetWeatherByCityName @Inject constructor(
    private val repository: OpenWeatherRepository
) {
    suspend operator fun invoke(city: City): Result<Weather> {
        return repository.getWeatherByCityName(city.name.toCityName())
    }
}