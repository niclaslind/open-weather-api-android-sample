package com.volvocars.openweathermapandroid.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.volvocars.openweathermapandroid.R
import com.volvocars.openweathermapandroid.domain.model.Weather
import com.volvocars.openweathermapandroid.presentation.util.*

@Composable
fun WeatherCard(
    weather: Weather,
) {
    val windowInfo = rememberWindowInfo()
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        ) {
            Text(
                text = weather.name,
                modifier = Modifier.fillMaxWidth(),
                style = when (windowInfo.screenWidthInfo) {
                    is WindowInfo.WindowType.Compact -> MaterialTheme.typography.h3
                    is WindowInfo.WindowType.Medium -> MaterialTheme.typography.h3
                    is WindowInfo.WindowType.Expanded -> MaterialTheme.typography.h2
                },
                textAlign = TextAlign.Start,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = weather.temp.asTemperatureCelsius(),
                    style = when (windowInfo.screenWidthInfo) {
                        is WindowInfo.WindowType.Compact -> MaterialTheme.typography.body1
                        is WindowInfo.WindowType.Medium -> MaterialTheme.typography.body1
                        is WindowInfo.WindowType.Expanded -> MaterialTheme.typography.body1
                    }
                )
                weather.iconUrl?.let { url ->
                    AsyncImage(
                        model = url,
                        contentDescription = "weather_icon",
                        modifier = when (windowInfo.screenWidthInfo) {
                            is WindowInfo.WindowType.Compact -> Modifier.size(120.dp)
                            is WindowInfo.WindowType.Medium -> Modifier.size(180.dp)
                            is WindowInfo.WindowType.Expanded -> Modifier.size(240.dp)
                        },
                        contentScale = ContentScale.Fit
                    )
                }
            }
            WeatherPropertyRow(
                propertyName = stringResource(R.string.weather_property_humidity),
                propertyValue = weather.humidity.toString()
            )
            WeatherPropertyRow(
                propertyName = stringResource(R.string.weather_property_wind),
                propertyValue = "${weather.windDirection.asWindDirectionDegrees()} ${weather.windSpeed.asWindSpeedMeterPerSecond()}"
            )
            WeatherPropertyRow(
                propertyName = stringResource(id = R.string.weather_property_pressure),
                propertyValue = weather.pressure.toString()
            )
        }
    }
}