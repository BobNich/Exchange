package com.exchange.feature.wallet.ui.interactor.wallet

import com.exchange.core.ui.Flowable
import com.exchange.feature.wallet.domain.GetUserWalletActionState
import com.exchange.feature.wallet.domain.GetUserWalletUseCase
import javax.inject.Inject


interface GetUserWalletInteractor<T : Any> {

    suspend fun get()

    class Base<T : Any> @Inject constructor(
        private val useCase: GetUserWalletUseCase,
        private val uiMapper: GetUserWalletActionState.Mapper<T>,
        private val observable: Flowable.Mutable<T>,
    ) : GetUserWalletInteractor<T> {

        override suspend fun get() {
            useCase().collect {
                observable.update(it.map(uiMapper))
            }
        }
    }
}
