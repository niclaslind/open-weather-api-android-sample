package com.volvocars.openweathermapandroid.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MainDto(
    val temp: Double,
    val pressure: Double,
    val humidity: Double,
    @SerialName("temp_min") val tempMain: Double,
    @SerialName("temp_max") val tempMax: Double,
)