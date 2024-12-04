package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.core.ui.StateFlowWrapper
import com.exchange.feature.signup.domain.SignupActionState
import com.exchange.feature.signup.domain.SignupUseCase
import com.exchange.feature.signup.domain.UserSignupForm
import javax.inject.Inject


interface SignupInteractor<T : Any> {

    suspend fun signup(
        username: String,
        password: String
    )

    class Base<T : Any> @Inject constructor(
        private val useCase: SignupUseCase,
        private val uiMapper: SignupActionState.Mapper<T>,
        private val observable: StateFlowWrapper.Mutable<T>
    ) : SignupInteractor<T> {
        override suspend fun signup(
            username: String,
            password: String
        ) {
            useCase(
                form = UserSignupForm(
                    username = username,
                    password = password
                )
            ).collect { state ->
                observable.update(state.map(uiMapper))
            }
        }
    }
}
