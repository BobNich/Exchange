package com.exchange.feature.buy.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.exchange.feature.buy.ui.Offer
import com.exchange.feature.buy.ui.Session
import com.exchange.feature.buy.ui.content.component.ExchangeRate
import com.exchange.feature.buy.ui.content.component.Header


@Composable
fun BuyScreenContent(
    offer: Offer,
    session: Session,
    onValueChange: (Float) -> Unit,
    onBuyClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var value by rememberSaveable {
        mutableStateOf("0")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                space = 28.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Header(
                onBackClick = onBackClick
            )
            ExchangeRate(
                giveCode = offer.buyCode,
                receiveCode = offer.sellCode,
                rateValue = offer.price.toString()
            )
            PayReceive(
                receiveAmount = value,
                payAmount = session.pay,
                receiveCode = offer.sellCode,
                payCode = offer.buyCode
            )
        }
        BuyKeyboard(
            modifier = Modifier.align(
                alignment = Alignment.BottomCenter
            ),
            maxValue = offer.maximum,
            onFormattedValueChange = {
                value = it
            },
            onValueChange = onValueChange,
            onBuyClick = onBuyClick,
            enabled = session.valid
        )
    }
}
