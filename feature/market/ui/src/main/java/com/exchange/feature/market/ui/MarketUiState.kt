package com.exchange.feature.market.ui

import com.exchange.feature.market.domain.CryptoOffer

interface MarketUiState {

    fun isLoading(): Boolean

    data object Loading : MarketUiState {
        override fun isLoading() = true
    }

    data class Success(
        val offers: List<CryptoOffer>
    ) : MarketUiState {
        override fun isLoading() = false
    }

    data class Failure(
        val message: String
    ) : MarketUiState {
        override fun isLoading() = false
    }
}