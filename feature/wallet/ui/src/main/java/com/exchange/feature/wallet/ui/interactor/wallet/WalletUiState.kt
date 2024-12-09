package com.exchange.feature.wallet.ui.interactor.wallet

import com.exchange.core.domain.UserAsset


interface WalletUiState {
    fun isEmpty(): Boolean

    object Loading : WalletUiState {
        override fun isEmpty() = false
    }

    data class Success(
        val assets: List<UserAsset>
    ) : WalletUiState {
        override fun isEmpty() = assets.isEmpty()
    }
}
