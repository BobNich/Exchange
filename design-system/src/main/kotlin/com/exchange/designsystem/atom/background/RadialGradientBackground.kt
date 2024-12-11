package com.exchange.designsystem.atom.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.sqrt


@Composable
fun RadialGradientBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier
            .fillMaxSize()
            .drawWithCache {
                val center = Offset(size.width, 0f)
                val radius = size.run {
                    sqrt((width * width) + (height * height))
                }

                val radialGradient = Brush.radialGradient(
                    colors = listOf(
                        Color(0x99FF9C45),
                        Color(0x80FFB800),
                    ),
                    center = center,
                    radius = radius,
                )

                onDrawBehind {
                    drawRect(radialGradient)
                }
            },
    ) {
        content()
    }
}
