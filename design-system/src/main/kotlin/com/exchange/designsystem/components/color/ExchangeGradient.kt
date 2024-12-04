package com.exchange.designsystem.components.color

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.exchange.designsystem.atom.background.linearGradientBackground


object ExchangeGradient {
    val primaryLinear
        @Composable get() = linearGradientBackground(
            0f to MaterialTheme.colorScheme.secondary,
            1f to MaterialTheme.colorScheme.primary
        )
}
