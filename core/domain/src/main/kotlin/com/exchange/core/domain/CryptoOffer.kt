package com.exchange.core.domain


data class CryptoOffer(
    val id: String,
    val sellerUsername: String,
    val price: Float,
    val sellAssetCode: String,
    val buyAssetCode: String,
    val availableAmount: Float,
    val minimumAmount: Float,
    val maximumAmount: Float
) {
    init {
        require(id.isNotEmpty()) {
            "Offer ID cannot be empty"
        }
        require(sellerUsername.isNotEmpty()) {
            "Seller username cannot be empty"
        }
        require(price >= 0) {
            "Price must be >= 0"
        }
        require(sellAssetCode.isNotEmpty()) {
            "Sell asset code cannot be empty"
        }
        require(buyAssetCode.isNotEmpty()) {
            "Buy asset code cannot be empty"
        }
        require(availableAmount >= 0) {
            "Available amount must be >= 0"
        }
        require(minimumAmount >= 0) {
            "Minimum amount must be >= 0"
        }
        require(maximumAmount > minimumAmount) {
            "Maximum amount must be > minimum"
        }
    }
}
