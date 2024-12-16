package com.exchange.feature.buy.ui.interactor

import com.exchange.feature.buy.domain.BuyActionState
import com.exchange.feature.buy.ui.BuyUiState
import javax.inject.Inject


class BuyOfferStateMapper @Inject constructor(
) : BuyActionState.Mapper<BuyUiState> {
    override fun progress(): BuyUiState {
        return BuyUiState.Loading
    }

    override fun success(): BuyUiState {
        return BuyUiState.Success
    }

    override fun failure(message: String): BuyUiState {
        return BuyUiState.Failure(message = message)
    }
}
