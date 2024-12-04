package com.exchange.feature.signup.data

import com.exchange.cloud.service.register.RegisterCloudDataSource
import com.exchange.feature.signup.domain.SignupRepository
import com.exchange.feature.signup.domain.UserSignupForm
import javax.inject.Inject


internal class SignupRepositoryImpl @Inject constructor(
    private val cloudDataSource: RegisterCloudDataSource
) : SignupRepository {
    override suspend fun register(form: UserSignupForm) {
        cloudDataSource.register(
            username = form.username,
            password = form.password
        )
    }
}
