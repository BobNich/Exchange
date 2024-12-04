package com.exchange.designsystem.components.progress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.exchange.designsystem.R
import kotlinx.coroutines.delay


@Composable
fun ExchangeProgress(
    modifier: Modifier = Modifier
) {
    val animated by remember { mutableStateOf(true) }
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(animated) {
        while (animated) {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = tween(durationMillis = 1000)
            )
            rotation.snapTo(0f)
            delay(1000)
        }
    }

    Image(
        modifier = modifier
            .graphicsLayer {
                rotationZ = rotation.value
            },
        painter = painterResource(id = R.drawable.ic_app),
        contentDescription = "Rotating Icon",
    )
}

@Preview
@Composable
private fun PreviewExchangeProgress() {
    ExchangeProgress()
}
