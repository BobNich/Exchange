package com.exchange.feature.market.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.exchange.core.domain.CryptoOffer
import com.exchange.feature.market.ui.content.MarketScreenContent
import com.exchange.feature.market.ui.content.component.Refreshable


@Composable
fun MarketRoute(
    viewModel: MarketViewModel,
    navigateBack: () -> Unit,
    navigateToBuy: (offer: CryptoOffer) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel
        .uiState()
        .collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getCryptoOffers()
    }

    Refreshable(
        refreshing = uiState.isLoading(),
        onRefresh = {
            viewModel.getCryptoOffers()
        }
    ) {
        MarketScreenContent(
            modifier = modifier,
            uiState = uiState,
            onBackClicked = navigateBack,
            onBuyClick = navigateToBuy
        )
    }
}
