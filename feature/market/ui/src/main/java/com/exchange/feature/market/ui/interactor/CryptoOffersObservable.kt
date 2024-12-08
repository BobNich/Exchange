package com.exchange.feature.market.ui.interactor

import com.exchange.core.ui.AbstractStateFlowWrapper
import com.exchange.feature.market.ui.MarketUiState
import javax.inject.Inject


class CryptoOffersObservable @Inject constructor(
) : AbstractStateFlowWrapper<MarketUiState>(
    initialState = MarketUiState.Loading
)
