package com.exchange.feature.market.ui.content.component.offer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.button.ExchangeButton
import com.exchange.designsystem.components.text.SingleText
import com.exchange.designsystem.modifier.removeSizeConstraints
import com.exchange.feature.market.ui.R


@Composable
fun OfferTopSection(
    onBuyClick: () -> Unit,
    price: String,
    buyCode: String,
    sellCode: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
        ) {
            SingleText(
                text = JustText(
                    text = stringResource(
                        R.string.offer_top_section_title,
                        price,
                        buyCode
                    ),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            SingleText(
                text = JustText(
                    text = stringResource(
                        R.string.offer_top_section_subtitle,
                        sellCode
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
        }
        BuyButton(
            modifier = Modifier
                .align(alignment = Alignment.CenterEnd),
            onClick = onBuyClick
        )
    }
}


@Composable
fun BuyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExchangeButton(
        modifier = modifier
            .removeSizeConstraints(),
        onClick = onClick,
        background = solidBackground(
            color = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(
            size = 4.dp
        )
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.buy_button_text
                ),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}
