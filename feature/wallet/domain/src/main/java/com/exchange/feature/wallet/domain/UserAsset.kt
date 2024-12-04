package com.exchange.feature.wallet.domain


data class UserAsset(
    val name: String,
    val code: String,
    val amount: Float
) {
    init {
        require(
            code.uppercase() == code
        ) {
            "Code must be in upper case"
        }
        require(code.isNotEmpty()) {
            "Code cannot be empty"
        }
        require(name.isNotEmpty()) {
            "Name cannot be empty"
        }
        require(amount >= 0) {
            "Amount must be >= 0"
        }
    }
}
