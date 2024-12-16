package com.exchange.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun ApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightScheme,
        typography = AppTypography,
        content = content
    )
}
