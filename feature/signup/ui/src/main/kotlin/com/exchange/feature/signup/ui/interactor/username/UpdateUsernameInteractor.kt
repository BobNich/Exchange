package com.exchange.feature.signup.ui.interactor.username

import com.exchange.core.ui.StateFlowWrapper
import javax.inject.Inject


interface UpdateUsernameInteractor<T : Any> {

    fun update(
        text: String
    )

    class Base<T: Any> @Inject constructor(
        private val observable: StateFlowWrapper.Mutable<UsernameUiState>,
    ) : UpdateUsernameInteractor<T> {
        override fun update(text: String) {
            observable.update(
                value = UsernameUiState.SuccessValidation(text)
            )
        }
    }
}
