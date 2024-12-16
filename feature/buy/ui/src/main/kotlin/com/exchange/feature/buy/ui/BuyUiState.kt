package com.exchange.feature.buy.ui

import androidx.compose.runtime.Stable

sealed interface BuyUiState {

    data object Loading : BuyUiState

    data class Failure(
        val message: String
    ) : BuyUiState

    data object Success : BuyUiState

}

@Stable
data class Offer(
    val price: Float,
    val sellCode: String,
    val buyCode: String,
    val minimum: Float,
    val maximum: Float
)

@Stable
data class Session(
    val value: Float,
    val pay: String,
    val valid: Boolean
)

