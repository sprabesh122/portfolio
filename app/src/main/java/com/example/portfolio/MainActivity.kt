package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.portfolio.feature.models.Profile
import com.example.portfolio.feature.models.Recognition
import com.example.portfolio.feature.models.TopBar
import com.example.portfolio.feature.presentation.HomeScreen
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            var isDarkTheme by rememberSaveable {
                mutableStateOf(false)
            }

            PortfolioTheme(
                darkTheme = isDarkTheme
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->

                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        HomeScreen(
                            topBar = TopBar(
                                pageName = "Portfolio"
                            ),
                            profile = Profile(
                                name = "Prabesh Sah",
                                role = "Android Developer"
                            ),
                            recognitions = listOf(
                                Recognition(
                                    title = "Webby Award",
                                    year = "2025",
                                    description = "Apps & Software — Shopping/Retail. Awarded to Lowe’s mobile app; Prabesh contributed as Android Developer."
                                ),
                                Recognition(
                                    title = "Raise the Roof",
                                    year = "Jan 2026",
                                    description = "Lowe’s India · Gig Promo Loyalty ownership and stable rollout."
                                ),
                                Recognition(
                                    title = "Spot Award",
                                    year = "Jun 2025",
                                    description = "Lowe’s India · High-impact delivery and critical issue resolution."
                                )
                            ),
                            isDarkTheme = isDarkTheme,
                            onThemeClick = {
                                isDarkTheme = !isDarkTheme
                            }
                        )
                    }
                }
            }
        }
    }
}
