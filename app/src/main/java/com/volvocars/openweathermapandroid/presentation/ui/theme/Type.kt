package com.volvocars.openweathermapandroid.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.volvocars.openweathermapandroid.R

val VolvoNovum = FontFamily(
    Font(R.font.volvo_novum_light, FontWeight.Normal),
    Font(R.font.volvo_novum_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Bold,
        fontSize = 58.sp
    ),
    h2 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Bold,
        fontSize = 46.sp
    ),
    h3 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    h4 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    body1 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Normal,
        fontSize = 90.sp
    ),
    body2 = TextStyle(
        fontFamily = VolvoNovum,
        fontWeight = FontWeight.Normal,
        fontSize = 80.sp
    ),
)