package com.exchange.feature.wallet.ui.interactor.username

import com.exchange.core.ui.Flowable
import com.exchange.feature.wallet.domain.GetUsernameUseCase
import javax.inject.Inject


interface GetUsernameInteractor<T : Any> {

    suspend fun get()

    class Base<T : Any> @Inject constructor(
        private val useCase: GetUsernameUseCase,
        private val observable: Flowable.Mutable<String>,
    ) : GetUsernameInteractor<T> {

        override suspend fun get() {
            val username = useCase()
            observable.update(username)
        }
    }
}
