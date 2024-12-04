package com.exchange.feature.market.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.exchange.feature.market.ui.content.MarketScreenContent


@Composable
fun MarketRoute(
    viewModel: MarketViewModel,
    navigateBack: () -> Unit,
    navigateToBuy: (id: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel
        .uiState()
        .collectAsStateWithLifecycle()

    MarketScreenContent(
        modifier = modifier,
        uiState = uiState,
        onBackClicked = navigateBack,
        onBuyClick = navigateToBuy
    )
}
