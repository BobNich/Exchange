package com.exchange.feature.market.ui.interactor

import com.exchange.core.domain.CryptoOffer
import com.exchange.feature.market.domain.GetCryptoOffersActionState
import com.exchange.feature.market.ui.MarketUiState
import javax.inject.Inject


class CryptoOffersStateMapper @Inject constructor(
) : GetCryptoOffersActionState.Mapper<MarketUiState> {
    override fun progress(): MarketUiState {
        return MarketUiState.Loading
    }

    override fun success(offers: List<CryptoOffer>): MarketUiState {
        return MarketUiState.Success(offers = offers)
    }

    override fun failure(message: String): MarketUiState {
        return MarketUiState.Failure(message = message)
    }
}
