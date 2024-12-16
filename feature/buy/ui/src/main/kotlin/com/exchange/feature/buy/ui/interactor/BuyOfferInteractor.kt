package com.exchange.feature.buy.ui.interactor

import com.exchange.core.ui.Eventable
import com.exchange.feature.buy.domain.BuyActionState
import com.exchange.feature.buy.domain.BuyRequest
import com.exchange.feature.buy.domain.BuyUseCase
import javax.inject.Inject


interface BuyOfferInteractor<Observe : Any, Event: Any> {

    suspend fun buy(request: BuyRequest)

    class Base<Observe : Any, Event: Any> @Inject constructor(
        private val useCase: BuyUseCase,
        private val uiMapper: BuyActionState.Mapper<Observe>,
        private val eventable: Eventable<Observe, Event>
    ) : BuyOfferInteractor<Observe, Event> {
        override suspend fun buy(request: BuyRequest) {
            useCase(request).collect { state ->
                val mapped = state.map(uiMapper)
                eventable.put(mapped)
            }
        }
    }
}
