package com.volvocars.openweathermapandroid.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherPropertyRow(propertyName: String, propertyValue: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = propertyName, style = MaterialTheme.typography.h5)
        Text(
            text = propertyValue,
            style = MaterialTheme.typography.h5
        )
    }
}