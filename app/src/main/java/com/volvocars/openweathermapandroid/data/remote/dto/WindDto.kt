package com.volvocars.openweathermapandroid.data.remote.dto

@kotlinx.serialization.Serializable
data class WindDto(
    val speed: Double,
    val deg: Double,
)