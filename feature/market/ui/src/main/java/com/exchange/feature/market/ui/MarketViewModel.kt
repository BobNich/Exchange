package com.exchange.feature.market.ui

import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Flowable
import com.exchange.feature.market.ui.interactor.GetCryptoOffersInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MarketViewModel @Inject constructor(
    private val getCryptoOffersAction: GetCryptoOffersInteractor<MarketUiState>,
    private val observe: Flowable.Mutable<MarketUiState>,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    fun uiState() = observe.state()

    fun getCryptoOffers() = async {
        getCryptoOffersAction.get()
    }

}
