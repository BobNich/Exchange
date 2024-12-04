package com.exchange.feature.sell.domain


sealed interface SellActionState {
    data object Progress : SellActionState

    data object Success : SellActionState

    data class Failure(
        val message: String
    ) : SellActionState
}
