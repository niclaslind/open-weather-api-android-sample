package com.volvocars.openweathermapandroid.domain.model

data class Weather(
    val name: String,
    val temp: Int,
    val humidity: Int,
    val windSpeed: Int,
    val windDirection: Int,
    val pressure: Int,
    val mainCondition: String? = null,
    val iconUrl: String? = null,
)