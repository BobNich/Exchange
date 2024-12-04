package com.exchange.feature.login.domain


interface LoginRepository {
    suspend fun authenticate(form: UserLoginForm)
}
