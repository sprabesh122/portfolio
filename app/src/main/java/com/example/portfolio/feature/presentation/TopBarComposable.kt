package com.example.portfolio.feature.presentation

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R
import com.example.portfolio.feature.models.TopBar
import com.example.portfolio.ui.theme.PortfolioTheme

@Composable
fun TopBarComposable(
    topBar: TopBar,
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = PortfolioTheme.colors.greenSurface,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = PortfolioTheme.colors.green,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "PS",
                    color = PortfolioTheme.colors.green,
                    fontSize = 17.sp,
                    letterSpacing = (-1).sp
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                Text(
                    text = topBar.pageName,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 14.sp,
                    lineHeight = 17.sp
                )

                Text(
                    text = "PRABESH / ANDROID",
                    color = PortfolioTheme.colors.secondaryText,
                    fontSize = 9.sp,
                    lineHeight = 12.sp,
                    letterSpacing = 0.8.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        Row(
            modifier = Modifier
                .width(72.dp)
                .height(48.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
                .clickable(onClick = onThemeClick)
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_moon),
                contentDescription = "Change theme",
                modifier = Modifier.size(16.dp),
                tint = PortfolioTheme.colors.green
            )

            Text(
                text = if (isDarkTheme) "Dark" else "Light",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp,
                lineHeight = 13.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )
        }
    }
}