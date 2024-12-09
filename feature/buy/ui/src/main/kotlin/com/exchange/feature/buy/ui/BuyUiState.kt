package com.exchange.feature.buy.ui

sealed interface BuyUiState {

    fun isValid(): Boolean

    data object Invalid: BuyUiState {
        override fun isValid() = false
    }

    data object Valid: BuyUiState {
        override fun isValid() = true
    }

    data object Loading: BuyUiState {
        override fun isValid() = true
    }

}