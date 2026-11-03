package com.example.portfolio.feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.feature.models.Profile
import com.example.portfolio.ui.theme.PortfolioTheme

private val ProfileCardShape = RoundedCornerShape(20.dp)
private val ProfileMonogramShape = RoundedCornerShape(28.dp)
private val ProfileChipShape = RoundedCornerShape(50.dp)
private val ProfileButtonShape = RoundedCornerShape(14.dp)

@Composable
fun ProfileCard(
    profile: Profile,
    onExploreWorkClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = ProfileCardShape
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = ProfileCardShape
            )
    ) {
        ProfileIntro(profile = profile)

        Text(
            text = profile.name,
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 42.sp,
            lineHeight = 48.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-1).sp
        )

        Text(
            text = "Thoughtful UI. Resilient systems.",
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 18.dp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 20.sp,
            lineHeight = 26.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = "2+ years building scalable, production-grade Android apps. " +
                    "From API contracts to a stable release, I own the whole feature.",
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 18.dp
            ),
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 15.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal
        )

        ProfileMetadata()

        ExploreWorkButton(
            onClick = onExploreWorkClick
        )
    }
}

@Composable
private fun ProfileIntro(
    profile: Profile
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                top = 20.dp,
                end = 20.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(104.dp)
                .background(
                    color = PortfolioTheme.colors.greenSurface,
                    shape = ProfileMonogramShape
                )
                .border(
                    width = 1.dp,
                    color = PortfolioTheme.colors.green,
                    shape = ProfileMonogramShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "PS",
                color = PortfolioTheme.colors.green,
                fontSize = 46.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = (-2).sp
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "HELLO, I’M PRABESH",
                color = PortfolioTheme.colors.green,
                fontSize = 11.sp,
                lineHeight = 15.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.2.sp
            )

            RoleBadge(
                role = profile.role
            )

            Text(
                text = "Kotlin / Jetpack Compose",
                color = PortfolioTheme.colors.secondaryText,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
        }
    }
}

@Composable
private fun RoleBadge(
    role: String
) {
    Text(
        text = role,
        modifier = Modifier
            .background(
                color = PortfolioTheme.colors.greenSurface,
                shape = ProfileChipShape
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
        color = PortfolioTheme.colors.green,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
private fun ProfileMetadata() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 18.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProfileChip(
            text = "Lowe’s India"
        )

        ProfileChip(
            text = "Bengaluru"
        )
    }
}

@Composable
private fun ProfileChip(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier
            .background(
                color = PortfolioTheme.colors.chipSurface,
                shape = ProfileChipShape
            )
            .padding(
                horizontal = 12.dp,
                vertical = 7.dp
            ),
        color = PortfolioTheme.colors.secondaryText,
        fontSize = 12.sp,
        lineHeight = 18.sp
    )
}

@Composable
private fun ExploreWorkButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 16.dp,
                bottom = 20.dp
            )
            .background(
                color = PortfolioTheme.colors.green,
                shape = ProfileButtonShape
            )
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Explore my work  →",
            color = MaterialTheme.colorScheme.surface,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(
    name = "Profile - Light",
    showBackground = true,
    widthDp = 412
)
@Composable
private fun ProfileCardLightPreview() {
    PortfolioTheme(
        darkTheme = false
    ) {
        ProfileCard(
            profile = Profile(
                name = "Prabesh Sah",
                role = "Android Developer"
            )
        )
    }
}

@Preview(
    name = "Profile - Dark",
    showBackground = true,
    widthDp = 412
)
@Composable
private fun ProfileCardDarkPreview() {
    PortfolioTheme(
        darkTheme = true
    ) {
        ProfileCard(
            profile = Profile(
                name = "Prabesh Sah",
                role = "Android Developer"
            )
        )
    }
}