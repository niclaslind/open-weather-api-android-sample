package com.volvocars.openweathermapandroid.data.remote.dto

@kotlinx.serialization.Serializable
data class WeatherDto(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)