package com.exchange.feature.signup.domain

import kotlinx.coroutines.flow.Flow


interface SignupUseCase {
    suspend operator fun invoke(form: UserSignupForm): Flow<SignupActionState>
}
