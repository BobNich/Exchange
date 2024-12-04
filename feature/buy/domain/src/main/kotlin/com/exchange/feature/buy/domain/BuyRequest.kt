package com.exchange.feature.buy.domain


data class BuyRequest(
    val offerId: String,
    val amount: Float
) {
    init {
        require(amount > 0) {
            "Buy amount must be > 0"
        }
    }
}