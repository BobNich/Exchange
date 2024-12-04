package com.exchange.feature.login.domain

import kotlinx.coroutines.flow.Flow


interface LoginUseCase {
    operator fun invoke(form: UserLoginForm): Flow<LoginActionState>
}
