package com.exchange.feature.login.ui.interactor.login

import com.exchange.core.ui.Flowable
import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.domain.LoginUseCase
import com.exchange.feature.login.domain.UserLoginForm
import javax.inject.Inject


interface LoginInteractor<T : Any> {

    suspend fun login(
        username: String,
        password: String
    )

    class Base<T : Any> @Inject constructor(
        private val useCase: LoginUseCase,
        private val uiMapper: LoginActionState.Mapper<T>,
        private val observable: Flowable.Mutable<T>
    ) : LoginInteractor<T> {
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
                observable.update(state.map(uiMapper))
            }
        }
    }
}
