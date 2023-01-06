package com.volvocars.openweathermapandroid.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volvocars.openweathermapandroid.domain.model.City
import com.volvocars.openweathermapandroid.domain.use_case.GetWeatherByCityName
import com.volvocars.openweathermapandroid.domain.util.toCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val fetchWeatherInCity: GetWeatherByCityName,
) : ViewModel() {
    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState = _weatherState.asStateFlow()

    init {
        fetchWeather()
    }

    private fun fetchWeather() = viewModelScope.launch {
        _weatherState.value = weatherState.value.copy(isLoading = true)
        City.values().forEach { city ->
            fetchWeatherInCity(city).onSuccess { weather ->
                val weatherList = buildList {
                    addAll(weatherState.value.weathers)
                    add(weather)
                }
                _weatherState.value =
                    weatherState.value.copy(
                        weathers = weatherList, isError = false
                    )
            }.onFailure {
                Log.d(TAG, "fetchWeather: ${it.message?.toCityName()}")
                _weatherState.value =
                    weatherState.value.copy(
                        errorMessage = city.name.toCityName(), isError = true
                    )
            }
        }
        _weatherState.value = weatherState.value.copy(isLoading = false)
    }

    companion object {
        val TAG = WeatherViewModel::class.simpleName
    }
}