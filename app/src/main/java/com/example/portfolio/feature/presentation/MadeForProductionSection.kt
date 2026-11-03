package com.example.portfolio.feature.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R
import com.example.portfolio.ui.theme.PortfolioTheme

private val ProductionCardShape = RoundedCornerShape(20.dp)

@Composable
fun MadeForProductionSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ProductionSectionHeader()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MetricCard(
                modifier = Modifier.weight(1f),
                iconRes = R.drawable.ic_code_xml,
                iconColor = PortfolioTheme.colors.purple,
                value = "2+",
                label = "Years in Android"
            )

            MetricCard(
                modifier = Modifier.weight(1f),
                iconRes = R.drawable.ic_zap,
                iconColor = PortfolioTheme.colors.yellow,
                value = "10+",
                label = "Features delivered"
            )
        }

        QualityCard()
        RevenueImpactCard()
        MilestoneCard()
    }
}

@Composable
private fun ProductionSectionHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Made for production",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-0.5).sp
        )

        Text(
            text = "IMPACT / LOWE’S",
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 9.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
private fun MetricCard(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    iconColor: Color,
    value: String,
    label: String
) {
    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface,
                ProductionCardShape
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                ProductionCardShape
            )
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = iconColor
        )

        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 12.sp,
            lineHeight = 18.6.sp
        )
    }
}

@Composable
private fun QualityCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                PortfolioTheme.colors.greenSurface,
                ProductionCardShape
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                ProductionCardShape
            )
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_shield_check),
            contentDescription = null,
            modifier = Modifier.size(28.dp),
            tint = PortfolioTheme.colors.green
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "0 post-release P0 issues",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                lineHeight = 27.9.sp
            )

            Text(
                text = "Across delivered production features.",
                color = PortfolioTheme.colors.secondaryText,
                fontSize = 12.sp,
                lineHeight = 18.6.sp
            )
        }
    }
}

@Composable
private fun RevenueImpactCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface,
                ProductionCardShape
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                ProductionCardShape
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "GIG PROMO LOYALTY",
            color = PortfolioTheme.colors.green,
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.1.sp
        )

        Text(
            text = "$18M+",
            color = PortfolioTheme.colors.green,
            fontSize = 38.sp,
            lineHeight = 42.56.sp,
            letterSpacing = (-1).sp
        )

        Text(
            text = "Incremental revenue driven. End-to-end Android ownership, " +
                    "from technical spike and API contract through rollout.",
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 14.sp,
            lineHeight = 21.7.sp
        )
    }
}

@Composable
private fun MilestoneCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                PortfolioTheme.colors.purpleSurface,
                ProductionCardShape
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                ProductionCardShape
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "MILESTONE / AUG 2026",
            color = PortfolioTheme.colors.purple,
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.1.sp
        )

        Text(
            text = "Associate Software Engineer → Software Engineer at Lowe’s India",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 14.sp,
            lineHeight = 21.7.sp
        )
    }
}