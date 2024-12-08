package com.exchange.feature.market.ui.interactor

import com.exchange.core.ui.Flowable
import com.exchange.feature.market.domain.GetCryptoOffersActionState
import com.exchange.feature.market.domain.GetCryptoOffersUseCase
import javax.inject.Inject


interface GetCryptoOffersInteractor<T : Any> {

    suspend fun get()

    class Base<T : Any> @Inject constructor(
        private val useCase: GetCryptoOffersUseCase,
        private val uiMapper: GetCryptoOffersActionState.Mapper<T>,
        private val observable: Flowable.Mutable<T>,
    ) : GetCryptoOffersInteractor<T> {

        override suspend fun get() {
            useCase().collect {
                observable.update(it.map(uiMapper))
            }
        }
    }
}
