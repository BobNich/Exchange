package com.exchange.feature.buy.ui

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Eventable
import com.exchange.feature.buy.domain.BuyRequest
import com.exchange.feature.buy.ui.interactor.BuyOfferInteractor
import com.exchange.feature.buy.ui.interactor.GoBackChannelEventable

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class BuyViewModel @Inject constructor(
    private val buyAction: BuyOfferInteractor<BuyUiState, String>,
    private val messageEvent: Eventable<BuyUiState, String>,
    private val goBackEvent: GoBackChannelEventable,
    savedStateHandle: SavedStateHandle,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    private val offerMetadata = savedStateHandle
        .toRoute<Buy>()

    val offer = MutableStateFlow(
        value = Offer(
            price = offerMetadata.price,
            sellCode = offerMetadata.sellCode,
            buyCode = offerMetadata.buyCode,
            minimum = offerMetadata.minimumAmount,
            maximum = offerMetadata.maximumAmount,
        )
    )

    var session = MutableStateFlow(
        value = Session(
            value = 0f,
            pay = "0",
            valid = false
        )
    )

    fun toastEventChannel() = messageEvent.read()

    fun goBackEventChannel() = goBackEvent.read()

    fun process(
        value: Float,
        offer: Offer,
    ) {
        val valid = value in
                (offer.minimum..offer.maximum)
        val pay = (value * offer.price).toString()
        this.session.value = Session(
            value = value,
            pay = pay,
            valid = valid
        )
    }

    fun buy(amount: Float) = async {
        buyAction.buy(
            request = BuyRequest(
                offerId = offerMetadata.offerId,
                amount = amount
            )
        )
    }
}
