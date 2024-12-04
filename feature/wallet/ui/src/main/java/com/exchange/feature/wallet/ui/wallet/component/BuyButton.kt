package com.exchange.feature.wallet.ui.wallet.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.button.ExchangeButton
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.wallet.ui.R


@Composable
fun BuyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExchangeButton(
        modifier = modifier,
        onClick = onClick,
        background = solidBackground(
            color = MaterialTheme.colorScheme.tertiary
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        SingleText(
            text = JustText(
                text = stringResource(R.string.buy_button_text),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )
        )
    }
}
