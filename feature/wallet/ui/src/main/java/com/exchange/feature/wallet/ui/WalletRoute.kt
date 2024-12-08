package com.exchange.feature.wallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.exchange.feature.wallet.ui.content.wallet.WalletScreenContent


@Composable
fun WalletRoute(
    viewModel: WalletViewModel,
    navigateToSettings: () -> Unit,
    navigateToMarket: () -> Unit,
    navigateToSell: () -> Unit,
    modifier: Modifier = Modifier
) {
    val usernameState by viewModel
        .usernameState()
        .collectAsStateWithLifecycle()

    val walletUiState by viewModel
        .walletState()
        .collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.update()
    }

    WalletScreenContent(
        modifier = modifier,
        username = usernameState,
        uiState = walletUiState,
        onProfileClick = navigateToSettings,
        onBuyClick = navigateToMarket,
        onSellClick = navigateToSell
    )
}
