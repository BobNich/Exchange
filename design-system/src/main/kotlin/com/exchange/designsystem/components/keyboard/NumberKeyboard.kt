package com.exchange.designsystem.components.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.components.keyboard.data.NumberKeyboardData
import com.exchange.designsystem.components.keyboard.listener.NumberKeyboardClickedListener
import com.exchange.designsystem.components.keyboard.listener.NumberKeyboardListener


@Composable
fun NumberKeyboard(
    initialAmount: Double = 0.0,
    maxAllowedAmount: Double = 10_000.0,
    maxAllowedDecimals: Int = 2,
    roundUpToMax: Boolean = true,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(8.dp),
    listener: NumberKeyboardListener,
    modifier: Modifier = Modifier,
    button: @Composable (Int, NumberKeyboardClickedListener) -> Unit,
    leftButton: @Composable ((NumberKeyboardClickedListener) -> Unit),
    rightButton: @Composable ((NumberKeyboardClickedListener) -> Unit),
) {
    var amount by remember {
        mutableStateOf(
            if (initialAmount != 0.0) {
                initialAmount.toInt().toString()
            } else ""
        )
    }

    val decimalSeparator = '.'
    val groupingSeparator = ','

    val clickListener = object : NumberKeyboardClickedListener {
        override fun onNumberClicked(number: Int) {
            if (amount.isEmpty() && number == 0) return

            val appendedAmount = amount + number.toString()
            val standardisedAmount = appendedAmount
                .replace(",", ".")
                .toDoubleOrNull() ?: 0.0

            val separatorIndex = appendedAmount
                .indexOf(decimalSeparator)

            val numberOfDecimals = if (separatorIndex >= 0) {
                appendedAmount.length - separatorIndex - 1
            } else {
                0
            }

            if (numberOfDecimals > maxAllowedDecimals) return

            if (standardisedAmount in 0.0..maxAllowedAmount) {
                amount += number
            } else {
                amount = if (roundUpToMax) {
                    maxAllowedAmount
                        .toString()
                        .replace('.', decimalSeparator)
                } else {
                    amount
                }
            }

            listener.onUpdate(
                NumberKeyboardData(
                    amount,
                    decimalSeparator,
                    groupingSeparator,
                )
            )
        }

        override fun onLeftButtonClicked() {
            if (!amount.contains(decimalSeparator)) {
                amount = if (amount.isEmpty()) {
                    "0$decimalSeparator"
                } else {
                    "$amount$decimalSeparator"
                }
            }

            listener.onUpdate(
                NumberKeyboardData(
                    amount,
                    decimalSeparator,
                    groupingSeparator,
                )
            )
        }

        override fun onRightButtonClicked() {
            if (amount.isEmpty()) return

            val trimmedAmountText = amount
                .trimEnd(decimalSeparator)

            val newAmountText = if (trimmedAmountText.length <= 1) {
                ""
            } else {
                trimmedAmountText
                    .substring(0, trimmedAmountText.length - 1)
            }

            amount = newAmountText

            listener.onUpdate(
                NumberKeyboardData(
                    amount,
                    decimalSeparator,
                    groupingSeparator,
                )
            )
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement
        ) {
            listOf(1, 2, 3).forEach {
                button(it, clickListener)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement
        ) {
            listOf(4, 5, 6).forEach {
                button(it, clickListener)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement
        ) {
            listOf(7, 8, 9).forEach {
                button(it, clickListener)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement
        ) {
            leftButton(clickListener)
            button(0, clickListener)
            rightButton(clickListener)
        }
    }
}
