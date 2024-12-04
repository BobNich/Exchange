package com.exchange.designsystem.components.keyboard.item

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.components.button.ExchangeButton


@Composable
fun KeyboardItemImage(
    onClick: () -> Unit,
    painter: Painter,
    shape: Shape,
    modifier: Modifier = Modifier
) {
    ExchangeButton(
        onClick = onClick,
        background = solidBackground(
            color = MaterialTheme.colorScheme.background
        ),
        shape = shape,
        modifier = modifier
    ) {
        Icon(
            painter = painter,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
}
