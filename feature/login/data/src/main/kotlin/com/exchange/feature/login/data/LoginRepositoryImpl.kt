package com.exchange.feature.login.data

import com.exchange.account.UserAccount
import com.exchange.cloud.service.login.LoginCloudDataSource
import com.exchange.feature.login.domain.LoginRepository
import com.exchange.feature.login.domain.UserLoginForm
import javax.inject.Inject


internal class LoginRepositoryImpl @Inject constructor(
    private val cloudDataSource: LoginCloudDataSource,
    private val userAccount: UserAccount
) : LoginRepository {
    override suspend fun authenticate(form: UserLoginForm) {
        val token = cloudDataSource.login(
            username = form.username,
            password = form.password
        )
        userAccount.authenticate(
            username = form.username,
            accessToken = token.accessToken,
            refreshToken = token.refreshToken
        )
    }
}
