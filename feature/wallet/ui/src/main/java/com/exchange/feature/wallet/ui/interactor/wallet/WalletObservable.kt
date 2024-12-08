package com.exchange.feature.wallet.ui.interactor.wallet

import com.exchange.core.ui.AbstractStateFlowWrapper
import javax.inject.Inject


class WalletObservable @Inject constructor(
): AbstractStateFlowWrapper<WalletUiState>(
    initialState = WalletUiState.Loading
)
