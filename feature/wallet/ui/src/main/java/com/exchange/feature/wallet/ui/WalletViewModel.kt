package com.exchange.feature.wallet.ui

import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Flowable
import com.exchange.feature.wallet.ui.interactor.username.GetUsernameInteractor
import com.exchange.feature.wallet.ui.interactor.wallet.GetUserWalletInteractor
import com.exchange.feature.wallet.ui.interactor.wallet.WalletUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WalletViewModel @Inject constructor(
    private val getUsernameAction: GetUsernameInteractor<String>,
    private val getUserWalletAction: GetUserWalletInteractor<WalletUiState>,
    private val usernameObservable: Flowable.Mutable<String>,
    private val walletObservable: Flowable.Mutable<WalletUiState>,
    dispatchers: DispatchersList
) : BaseViewModel(dispatchers) {

    fun walletState() =
        walletObservable.state()

    fun usernameState() =
        usernameObservable.state()

    fun update() = async {
        getUsernameAction.get()
        getUserWalletAction.get()
    }

}
