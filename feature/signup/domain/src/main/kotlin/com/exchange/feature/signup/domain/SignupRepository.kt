package com.exchange.feature.signup.domain


interface SignupRepository {
    suspend fun register(form: UserSignupForm)
}
