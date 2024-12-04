package com.exchange.feature.buy.domain


sealed interface BuyActionState {
    data object Progress : BuyActionState

    data object Success : BuyActionState

    data class Failure(
        val message: String
    ) : BuyActionState
}
