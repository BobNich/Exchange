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
fun KeyboardItemNumber(
    number: Int,
    onClick: () -> Unit,
    textStyle: TextStyle,
    shape: Shape,
    modifier: Modifier = Modifier,
) {
    ExchangeButton(
        modifier = modifier,
        onClick = onClick,
        background = solidBackground(
            color = MaterialTheme.colorScheme.background
        ),
        shape = shape,
    ) {
        SingleText(
            text = JustText(
                text = number.toString(),
                style = textStyle,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}
