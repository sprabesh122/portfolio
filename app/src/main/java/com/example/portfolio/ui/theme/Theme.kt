package com.example.portfolio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PortfolioGreen,
    background = DarkBackground,
    onBackground = DarkPrimaryText,
    surface = DarkSurface,
    onSurface = DarkPrimaryText,
    outline = DarkBorder
)

private val LightColorScheme = lightColorScheme(
    primary = PortfolioGreen,
    background = LightBackground,
    onBackground = LightPrimaryText,
    surface = LightSurface,
    onSurface = LightPrimaryText,
    outline = LightBorder
)

@Immutable
data class PortfolioColors(
    val secondaryText: Color,
    val green: Color,
    val purple: Color,
    val yellow: Color,
    val greenSurface: Color,
    val purpleSurface: Color,
    val yellowSurface: Color,
    val chipSurface: Color
)

private val LightPortfolioColors = PortfolioColors(
    secondaryText = LightSecondaryText,
    green = PortfolioGreen,
    purple = PortfolioPurple,
    yellow = PortfolioYellow,
    greenSurface = LightGreenSurface,
    purpleSurface = LightPurpleSurface,
    yellowSurface = LightYellowSurface,
    chipSurface = LightChipSurface
)

private val DarkPortfolioColors = PortfolioColors(
    secondaryText = DarkSecondaryText,
    green = PortfolioGreen,
    purple = PortfolioPurple,
    yellow = PortfolioYellow,
    greenSurface = DarkGreenSurface,
    purpleSurface = DarkPurpleSurface,
    yellowSurface = DarkYellowSurface,
    chipSurface = DarkChipSurface
)

private val LocalPortfolioColors = staticCompositionLocalOf {
    LightPortfolioColors
}

object PortfolioTheme {
    val colors: PortfolioColors
        @Composable
        get() = LocalPortfolioColors.current
}

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (darkTheme) DarkColorScheme else LightColorScheme

    val portfolioColors =
        if (darkTheme) DarkPortfolioColors else LightPortfolioColors

    CompositionLocalProvider(
        LocalPortfolioColors provides portfolioColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}