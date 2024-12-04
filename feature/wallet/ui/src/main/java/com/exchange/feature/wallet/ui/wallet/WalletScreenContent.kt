package com.exchange.feature.wallet.ui.wallet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.background.RadialGradientBackground
import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.wallet.ui.wallet.component.BuyButton
import com.exchange.feature.wallet.ui.wallet.component.Greeting
import com.exchange.feature.wallet.ui.wallet.component.Header
import com.exchange.feature.wallet.ui.wallet.component.SellButton


@Composable
fun WalletScreenContent(
    username: String,
    onProfileClick: () -> Unit,
    onBuyClick: () -> Unit,
    onSellClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RadialGradientBackground(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Header(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                onProfileClick = onProfileClick
            )
            Greeting(
                modifier = Modifier
                    .padding(top = 52.dp)
                    .align(Alignment.CenterHorizontally),
                username = username
            )
            Row(
                modifier = Modifier.padding(
                    top = 52.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                BuyButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = onBuyClick
                )
                SellButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = onSellClick
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewWalletScreenContent() {
    ApplicationTheme {
        WalletScreenContent(
            username = "Bob",
            onProfileClick = {},
            onBuyClick = {},
            onSellClick = {}
        )
    }
}
