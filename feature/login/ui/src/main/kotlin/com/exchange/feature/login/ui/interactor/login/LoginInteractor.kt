package com.exchange.feature.login.ui.interactor.login

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Flowable
import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.domain.LoginUseCase
import com.exchange.feature.login.domain.UserLoginForm
import javax.inject.Inject


interface LoginInteractor<Observe : Any, Event: Any> {

    suspend fun login(
        username: String,
        password: String
    )

    class Base<Observe : Any, Event: Any> @Inject constructor(
        private val useCase: LoginUseCase,
        private val uiMapper: LoginActionState.Mapper<Observe>,
        private val observable: Flowable.Mutable<Observe>,
        private val eventable: Eventable<Observe, Event>
    ) : LoginInteractor<Observe, Event> {
        override suspend fun login(
            username: String,
            password: String
        ) {
            useCase(
                form = UserLoginForm(
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
