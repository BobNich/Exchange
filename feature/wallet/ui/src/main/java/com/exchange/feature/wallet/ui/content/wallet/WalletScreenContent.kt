package com.exchange.feature.wallet.ui.content.wallet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.exchange.feature.wallet.ui.content.assets.AssetsBottomSheet
import com.exchange.feature.wallet.ui.interactor.wallet.WalletUiState
import com.exchange.feature.wallet.ui.content.wallet.component.BuyButton
import com.exchange.feature.wallet.ui.content.wallet.component.Greeting
import com.exchange.feature.wallet.ui.content.wallet.component.Header
import com.exchange.feature.wallet.ui.content.wallet.component.SellButton


@Composable
fun WalletScreenContent(
    username: String,
    uiState: WalletUiState,
    onProfileClick: () -> Unit,
    onBuyClick: () -> Unit,
    onSellClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        WalletContent(
            modifier = modifier,
            username = username,
            uiState = uiState,
            onProfileClick = onProfileClick,
            onBuyClick = onBuyClick,
            onSellClick = onSellClick
        )
    }
}

@Composable
fun WalletContent(
    username: String,
    uiState: WalletUiState,
    onProfileClick: () -> Unit,
    onBuyClick: () -> Unit,
    onSellClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RadialGradientBackground(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(
                top = 20.dp
            ),
        ) {
            Header(
                modifier = modifier
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
        AssetsBottomSheet(
            uiState = uiState
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewWalletScreenContent() {
    ApplicationTheme {
        WalletScreenContent(
            username = "Bob",
            uiState = WalletUiState.Success(
                assets = emptyList()
            ),
            onProfileClick = {},
            onBuyClick = {},
            onSellClick = {}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewWalletScreenContentLoading() {
    ApplicationTheme {
        WalletScreenContent(
            username = "Bob",
            uiState = WalletUiState.Loading,
            onProfileClick = {},
            onBuyClick = {},
            onSellClick = {}
        )
    }
}
