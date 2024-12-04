package com.exchange.feature.login.ui.interactor.password

import com.exchange.core.ui.StateFlowWrapper
import javax.inject.Inject

interface UpdatePasswordInteractor<T : Any> {

    fun update(
        text: String
    )

    class Base<T : Any> @Inject constructor(
        private val observable: StateFlowWrapper.Mutable<PasswordUiState>,
    ) : UpdatePasswordInteractor<T> {
        override fun update(text: String) {
            observable.update(
                value = PasswordUiState.SuccessValidation(text)
            )
        }
    }
}