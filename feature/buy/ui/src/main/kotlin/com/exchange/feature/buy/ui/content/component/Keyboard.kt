package com.exchange.feature.buy.ui.content.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.components.keyboard.NumberKeyboard
import com.exchange.designsystem.components.keyboard.item.KeyboardItemImage
import com.exchange.designsystem.components.keyboard.item.KeyboardItemNumber
import com.exchange.designsystem.components.keyboard.item.KeyboardItemText
import com.exchange.feature.buy.ui.R


@Composable
fun Keyboard(
    maxValue: Float,
    onFormattedValueChange: (String) -> Unit,
    onValueChange: (Float) -> Unit,
    textStyle: TextStyle,
    itemShape: Shape,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        NumberKeyboard(
            maxAllowedAmount = maxValue.toDouble(),
            maxAllowedDecimals = 5,
            button = { number, listener ->
                KeyboardItemNumber(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1F),
                    number = number,
                    onClick = {
                        listener.onNumberClicked(number)
                    },
                    textStyle = textStyle,
                    shape = itemShape,
                )
            },
            leftButton = { listener ->
                KeyboardItemText(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1F),
                    text = ".",
                    onClick = {
                        listener.onLeftButtonClicked()
                    },
                    textStyle = textStyle,
                    shape = itemShape,
                )
            },
            rightButton = { listener ->
                KeyboardItemImage(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1F),
                    onClick = {
                        listener.onRightButtonClicked()
                    },
                    painter = painterResource(
                        id = R.drawable.backspace_icon
                    ),
                    shape = itemShape
                )
            },
            listener = { data ->
                onValueChange(data.value())
                onFormattedValueChange(data.formattedValue())
            }
        )
    }
}
