package com.exchange.feature.login.ui.interactor.username

import com.exchange.core.ui.Flowable
import javax.inject.Inject

interface UpdateUsernameInteractor<T : Any> {

    fun update(
        text: String
    )

    class Base<T : Any> @Inject constructor(
        private val observable: Flowable.Mutable<UsernameUiState>,
    ) : UpdateUsernameInteractor<T> {
        override fun update(text: String) {
            observable.update(
                value = UsernameUiState.SuccessValidation(text)
            )
        }
    }
}