package com.volvocars.openweathermapandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.volvocars.openweathermapandroid.presentation.ui.theme.OpenWeatherMapAndroidTheme
import com.volvocars.openweathermapandroid.presentation.weather.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherMapAndroidTheme {
                WeatherScreen()
            }
        }
    }

    companion object {
        val TAG = MainActivity::class.simpleName
    }
}
