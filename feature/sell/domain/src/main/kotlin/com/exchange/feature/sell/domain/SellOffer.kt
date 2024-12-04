package com.exchange.feature.sell.domain


data class SellOffer(
    val amount: Float,
    val pricePerOne: Float,
    val minimumSellAmount: Float,
    val maximumSellAmount: Float,
    val giveAssetCode: String,
    val getAssetCode: String,
) {
    init {
        require(amount > 0) {
            "Amount must be > 0"
        }
        require(pricePerOne > 0) {
            "Price per one must be > 0"
        }
        require(minimumSellAmount > 0) {
            "Minimum sell amount must be > 0"
        }
        require(maximumSellAmount > minimumSellAmount) {
            "Maximum sell amount must be > minimum"
        }
        require(giveAssetCode.isNotEmpty()) {
            "Give asset code cannot be empty"
        }
        require(getAssetCode.isNotEmpty()) {
            "Get asset code cannot be empty"
        }
    }
}
