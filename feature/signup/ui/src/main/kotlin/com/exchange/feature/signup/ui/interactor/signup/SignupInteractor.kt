package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Flowable
import com.exchange.feature.signup.domain.SignupActionState
import com.exchange.feature.signup.domain.SignupUseCase
import com.exchange.feature.signup.domain.UserSignupForm
import javax.inject.Inject


interface SignupInteractor<Observe : Any, Event: Any> {

    suspend fun signup(
        username: String,
        password: String
    )

    class Base<Observe : Any, Event: Any> @Inject constructor(
        private val useCase: SignupUseCase,
        private val uiMapper: SignupActionState.Mapper<Observe>,
        private val observable: Flowable.Mutable<Observe>,
        private val eventable: Eventable<Observe, Event>
    ) : SignupInteractor<Observe, Event> {
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
                val mapped = state.map(uiMapper)
                observable.update(mapped)
                eventable.put(mapped)
            }
        }
    }
}
