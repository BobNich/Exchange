package com.exchange.designsystem.components.keyboard.item

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.button.ExchangeButton
import com.exchange.designsystem.components.text.SingleText


@Composable
fun KeyboardItemText(
    onClick: () -> Unit,
    text: String,
    textStyle: TextStyle,
    shape: Shape,
    modifier: Modifier = Modifier,
) {
    ExchangeButton(
        onClick = onClick,
        background = solidBackground(
            color = MaterialTheme.colorScheme.background
        ),
        shape = shape,
        modifier = modifier
    ) {
        SingleText(
            text = JustText(
                text = text,
                style = textStyle,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}
