package com.volvocars.openweathermapandroid.presentation.weather

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.volvocars.openweathermapandroid.R
import com.volvocars.openweathermapandroid.domain.model.Weather
import com.volvocars.openweathermapandroid.presentation.components.WeatherCard
import com.volvocars.openweathermapandroid.presentation.ui.theme.DeepBlue
import com.volvocars.openweathermapandroid.presentation.ui.theme.TextWhite
import com.volvocars.openweathermapandroid.presentation.util.WindowInfo
import com.volvocars.openweathermapandroid.presentation.util.rememberWindowInfo

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
    windowInfo: WindowInfo = rememberWindowInfo(),
) {
    val weatherState = viewModel.weatherState.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.weatherState.collect {
            if (it.isError) {
                showErrorMessage(context, it.errorMessage)
            }
        }
    }

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            HeaderSection(windowInfo)
            if (weatherState.isLoading) {
                LoadingSection(windowInfo)
            }
            if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
                CompactSection(weatherState.weathers)
            } else {
                StandardSection(weatherState.weathers)
            }
        }
    }
}

fun showErrorMessage(context: Context, message: String?) {
    Toast.makeText(
        context,
        context.getString(R.string.error_failed_fetch_city, message),
        Toast.LENGTH_SHORT
    ).show()
}

@Composable
fun HeaderSection(windowInfo: WindowInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.header_text),
                color = TextWhite,
                style = when (windowInfo.screenWidthInfo) {
                    is WindowInfo.WindowType.Compact -> MaterialTheme.typography.h3
                    is WindowInfo.WindowType.Medium -> MaterialTheme.typography.h2
                    is WindowInfo.WindowType.Expanded -> MaterialTheme.typography.h1
                }
            )
        }
    }
}

@Composable
fun LoadingSection(windowInfo: WindowInfo) {
    Text(
        text = stringResource(id = R.string.fetch_header_text),
        color = TextWhite,
        modifier = Modifier.padding(15.dp),
        style = when (windowInfo.screenWidthInfo) {
            is WindowInfo.WindowType.Compact -> MaterialTheme.typography.h5
            is WindowInfo.WindowType.Medium -> MaterialTheme.typography.h4
            is WindowInfo.WindowType.Expanded -> MaterialTheme.typography.h3
        },
    )
}

@Composable
fun CompactSection(weathers: List<Weather>) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(weathers) { weather ->
            WeatherCard(weather)
        }
    }
}

@Composable
fun StandardSection(weathers: List<Weather>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            end = 12.dp,
            top = 16.dp,
            bottom = 16.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(weathers) { weather ->
            WeatherCard(weather)
        }
    }
}
