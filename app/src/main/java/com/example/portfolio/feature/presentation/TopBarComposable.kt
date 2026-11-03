package com.example.portfolio.feature.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R
import com.example.portfolio.feature.models.TopBar

private val AccentGreen = Color(0xFF5AE0AB)
private val MonogramBackground = Color(0xFF17382C)

private val PrimaryText = Color(0xFFF3F6F4)
private val SecondaryText = Color(0xFFABB8B0)

private val ThemeBackground = Color(0xFF17191E)
private val ThemeBorder = Color(0xFF30363C)

@Composable
fun TopBarComposable(
    topBar: TopBar,
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit
) {
    TopBarContent(
        pageName = topBar.pageName,
        isDarkTheme = isDarkTheme,
        onThemeClick = onThemeClick
    )
}

@Composable
private fun TopBarContent(
    pageName: String,
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderContent(
            pageName = pageName
        )

        ThemePreference(
            isDarkTheme = isDarkTheme,
            onClick = onThemeClick
        )
    }
}

@Composable
private fun HeaderContent(
    pageName: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MonoGram()

        PageTitle(
            pageName = pageName
        )
    }
}

@Composable
private fun MonoGram() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = MonogramBackground,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = AccentGreen,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "PS",
            color = AccentGreen,
            fontSize = 17.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-1).sp
        )
    }
}

@Composable
private fun PageTitle(
    pageName: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = pageName,
            color = PrimaryText,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = "PRABESH / ANDROID",
            color = SecondaryText,
            fontSize = 9.sp,
            lineHeight = 12.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.8.sp
        )
    }
}

@Composable
private fun ThemePreference(
    isDarkTheme: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .size(
                width = 72.dp,
                height = 48.dp
            )
            .background(
                color = ThemeBackground,
                shape = CircleShape
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = ThemeBorder
                ),
                shape = CircleShape
            )
            .clickable(
                onClick = onClick
            )
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_moon),
            contentDescription = "Change theme",
            modifier = Modifier.size(16.dp),
            tint = AccentGreen
        )

        Text(
            text = if (isDarkTheme) "Dark" else "Light",
            color = PrimaryText,
            fontSize = 11.sp,
            lineHeight = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF0D0F12,
    widthDp = 412
)
@Composable
private fun TopBarPreview() {
    TopBarComposable(
        topBar = TopBar(
            pageName = "Portfolio"
        ),
        isDarkTheme = true,
        onThemeClick = {}
    )
}