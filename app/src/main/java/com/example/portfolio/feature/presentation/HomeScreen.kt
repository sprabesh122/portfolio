package com.example.portfolio.feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.portfolio.feature.models.Profile
import com.example.portfolio.feature.models.Recognition
import com.example.portfolio.feature.models.TopBar

@Composable
fun HomeScreen(
    topBar: TopBar,
    profile: Profile,
    recognitions: List<Recognition>,
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit
) {
    val lazyState = rememberLazyListState()

    LazyColumn(
        state = lazyState,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item(key = "top_bar") {
            TopBarComposable(
                topBar = topBar,
                isDarkTheme = isDarkTheme,
                onThemeClick = onThemeClick
            )
        }

        item(key = "profile") {
            ProfileCard(
                profile = profile
            )
        }

        item(key = "made_for_production") {
            MadeForProductionSection()
        }

        item(key = "recognition") {
            RecognitionSection(
                recognitions = recognitions
            )
        }
    }
}