package com.volvocars.openweathermapandroid.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoordDto(
    val lon: Double,
    val lat: Double,
)