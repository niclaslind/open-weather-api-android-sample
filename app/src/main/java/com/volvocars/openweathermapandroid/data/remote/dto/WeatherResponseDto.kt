package com.volvocars.openweathermapandroid.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherResponseDto(
    @SerialName("coord") val cord: CoordDto,
    val weather: List<WeatherDto>,
    val base: String,
    val main: MainDto,
    val visibility: Int,
    val wind: WindDto,
    val clouds: CloudsDto,
    val dt: Long,
    val sys: SysDto,
    val id: Long,
    val name: String,
    val cod: Int,
)