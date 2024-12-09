package com.exchange.feature.wallet.ui.interactor.wallet

import com.exchange.core.domain.UserWallet
import com.exchange.feature.wallet.domain.GetUserWalletActionState
import javax.inject.Inject


class UserWalletStateMapper @Inject constructor(
) : GetUserWalletActionState.Mapper<WalletUiState> {
    override fun progress(): WalletUiState {
        return WalletUiState.Loading
    }

    override fun success(wallet: UserWallet): WalletUiState {
        return WalletUiState.Success(assets = wallet.assets)
    }

    override fun failure(message: String): WalletUiState {
        return WalletUiState.Loading
    }
}
