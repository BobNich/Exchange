package com.exchange.designsystem.components.button

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.button.CoreButton


@Composable
fun ExchangeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Brush = solidBackground(
        color = MaterialTheme.colorScheme.primary
    ),
    shape: Shape = RoundedCornerShape(18.dp),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    CoreButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        background = background,
        shape = shape,
        contentPadding = contentPadding
    ) {
        content()
    }
}

@Composable
fun LoadableExchangeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    loading: Boolean,
    background: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = RoundedCornerShape(18.dp),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    var buttonSize by remember {
        mutableStateOf(IntSize.Zero)
    }

    val infiniteTransition = rememberInfiniteTransition(
        label = "Infinite Transition"
    )

    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = -1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Animated Offset"
    )

    val brush = if (loading) {
        Brush.linearGradient(
            colors = listOf(
                background.copy(alpha = 0.5f),
                background.copy(alpha = 0.7f),
                background,
                background.copy(alpha = 0.7f),
                background.copy(alpha = 0.5f),
            ),
            start = Offset(
                animatedOffset * buttonSize.width,
                animatedOffset * buttonSize.height
            ),
            end = Offset(
                (animatedOffset + 1) * buttonSize.width,
                (animatedOffset + 1) * buttonSize.height
            )
        )
    } else {
        solidBackground(color = background)
    }

    CoreButton(
        modifier = modifier.onSizeChanged { size ->
            buttonSize = size
        },
        onClick = onClick,
        enabled = !loading,
        background = brush,
        shape = shape,
        contentPadding = contentPadding
    ) {
        content()
    }
}
