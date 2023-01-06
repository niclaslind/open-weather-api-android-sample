package com.volvocars.openweathermapandroid.data.remote.dto

@kotlinx.serialization.Serializable
data class SysDto(
    val type: Int,
    val id: Long,
    val message: Double? = null,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)
