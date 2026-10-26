package com.example.netflixtheme.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val NetflixFontFamily = FontFamily.Default

val NetflixTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp, lineHeight = 40.sp,
        color = NetflixWhite
    ),
    displayMedium = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp, lineHeight = 34.sp,
        color = NetflixWhite
    ),
    displaySmall = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp, lineHeight = 30.sp,
        color = NetflixWhite
    ),
    headlineLarge = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp, lineHeight = 28.sp,
        color = NetflixWhite
    ),
    headlineMedium = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp, lineHeight = 26.sp,
        color = NetflixWhite
    ),
    titleLarge = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp, lineHeight = 24.sp,
        color = NetflixWhite
    ),
    titleMedium = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp, lineHeight = 22.sp,
        color = NetflixWhite
    ),
    titleSmall = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp, lineHeight = 20.sp,
        color = NetflixWhite
    ),
    bodyLarge = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp, lineHeight = 24.sp,
        color = NetflixTextGray
    ),
    bodyMedium = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp, lineHeight = 20.sp,
        color = NetflixTextGray
    ),
    bodySmall = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp, lineHeight = 16.sp,
        color = NetflixTextGray
    ),
    labelLarge = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp, lineHeight = 20.sp,
        color = NetflixWhite
    ),
    labelMedium = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp, lineHeight = 16.sp,
        color = NetflixTextGray
    ),
    labelSmall = TextStyle(
        fontFamily = NetflixFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp, lineHeight = 14.sp,
        color = NetflixTextGray
    )
)
