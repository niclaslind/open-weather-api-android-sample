package com.volvocars.openweathermapandroid.presentation.util

fun Int.asTemperatureCelsius(): String {
    return "$this${Typography.degree}C"
}

fun Int.asWindDirectionDegrees(): String {
    return "${this}${Typography.degree}"
}

fun Int.asWindSpeedMeterPerSecond(): String {
    return "$this m/s"
}