package com.exchange.feature.market.ui

import com.exchange.feature.market.domain.CryptoOffer

interface MarketUiState {
    data object Loading : MarketUiState

    data class Success(
        val offers: List<CryptoOffer>
    ) : MarketUiState

    data class Failure(
        val message: String
    ) : MarketUiState
}