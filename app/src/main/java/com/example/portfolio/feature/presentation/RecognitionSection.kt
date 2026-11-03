package com.example.portfolio.feature.presentation

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R
import com.example.portfolio.feature.models.Recognition
import com.example.portfolio.ui.theme.PortfolioTheme

private val RecognitionCardShape = RoundedCornerShape(20.dp)

@Composable
fun RecognitionSection(
    recognitions: List<Recognition>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        RecognitionHeader()

        recognitions.forEachIndexed { index, recognition ->
            RecognitionCard(
                recognition = recognition,
                backgroundColor = recognitionBackground(index)
            )
        }
    }
}

@Composable
private fun RecognitionHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recognition",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp,
            letterSpacing = (-0.5).sp
        )

        Text(
            text = "THE WORK, RECOGNIZED",
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 9.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
private fun RecognitionCard(
    recognition: Recognition,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                backgroundColor,
                RecognitionCardShape
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RecognitionCardShape
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_trophy),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = PortfolioTheme.colors.green
            )

            Text(
                text = recognitionTitle(recognition),
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 16.sp,
                lineHeight = 24.8.sp
            )
        }

        Text(
            text = recognition.description,
            color = PortfolioTheme.colors.secondaryText,
            fontSize = 12.sp,
            lineHeight = 18.6.sp
        )
    }
}

private fun recognitionTitle(
    recognition: Recognition
): String {
    return "${recognition.title} · ${recognition.year}"
}

@Composable
private fun recognitionBackground(
    index: Int
): Color {
    return when (index) {
        0 -> PortfolioTheme.colors.yellowSurface
        1 -> PortfolioTheme.colors.greenSurface
        else -> PortfolioTheme.colors.purpleSurface
    }
}