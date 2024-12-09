package com.exchange.feature.buy.ui

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.feature.buy.domain.BuyRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BuyViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    private val offerId = savedStateHandle
        .toRoute<Buy>()
        .offerId

    fun buy(amount: Float) = async {
        val request = BuyRequest(
            offerId = offerId,
            amount = amount
        )
    }
}
