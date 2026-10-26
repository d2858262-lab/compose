package com.example.netflixtheme.ui.theme

import android.app.Activity
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val NetflixColorScheme = darkColorScheme(
    primary = NetflixRed,
    onPrimary = NetflixWhite,
    primaryContainer = NetflixDarkRed,
    onPrimaryContainer = NetflixWhite,
    secondary = NetflixTextGray,
    onSecondary = NetflixWhite,
    secondaryContainer = NetflixMediumGray,
    onSecondaryContainer = NetflixWhite,
    tertiary = NetflixGold,
    onTertiary = NetflixBlack,
    background = NetflixBlack,
    onBackground = NetflixWhite,
    surface = NetflixSurface,
    onSurface = NetflixWhite,
    surfaceVariant = NetflixSurfaceVariant,
    onSurfaceVariant = NetflixTextGray,
    error = Color(0xFFCF6679),
    onError = NetflixBlack,
    outline = NetflixLightGray,
    outlineVariant = NetflixDarkGray,
    inverseSurface = NetflixWhite,
    inverseOnSurface = NetflixBlack,
    inversePrimary = NetflixDarkRed,
    surfaceTint = NetflixRed,
    scrim = Color(0x99000000)
)

@Composable
fun NetflixTheme(content: @Composable () -> Unit) {
    val colorScheme = NetflixColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = NetflixBlack.toArgb()
            window.navigationBarColor = NetflixBlack.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = NetflixTypography,
        shapes = NetflixShapes,
        content = content
    )
}
