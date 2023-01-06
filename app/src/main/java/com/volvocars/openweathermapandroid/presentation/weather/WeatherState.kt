package com.volvocars.openweathermapandroid.presentation.weather

import com.volvocars.openweathermapandroid.domain.model.Weather

data class WeatherState(
    val weathers: List<Weather> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)