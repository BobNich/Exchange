package com.exchange.feature.wallet.ui.content.assets.component.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.button.ExchangeButton
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.wallet.ui.R


@Composable
fun BuyButton(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    ExchangeButton(
        modifier = modifier,
        onClick = onClick,
        background = if (enabled) {
            solidBackground(
                color = MaterialTheme.colorScheme.tertiary
            )
        } else {
            solidBackground(
                color = MaterialTheme.colorScheme.secondary
            )
        },
        enabled = enabled,
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.buy_button_text
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.background
            )
        )
    }
}
