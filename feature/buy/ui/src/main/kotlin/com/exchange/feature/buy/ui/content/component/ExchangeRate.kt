package com.exchange.feature.buy.ui.content.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.buy.ui.R


@Composable
fun ExchangeRate(
    giveCode: String,
    receiveCode: String,
    rateValue: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    R.string.exchange_rate_text,
                    receiveCode,
                    rateValue,
                    giveCode
                ),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
        )
    }
}
