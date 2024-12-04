package com.exchange.designsystem.atom.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


@Composable
fun linearGradientBackground(vararg colors: Pair<Float, Color>): Brush {
    return remember(colors) {
        Brush.linearGradient(
            colorStops = colors
        )
    }
}
