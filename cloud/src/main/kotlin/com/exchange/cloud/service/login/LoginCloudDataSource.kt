package com.exchange.cloud.service.login

import com.exchange.cloud.service.login.model.AccessRefreshTokens
import com.exchange.cloud.service.login.model.AccessToken
import com.exchange.cloud.service.login.model.RefreshToken
import com.exchange.cloud.service.login.model.UserCredentials
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface LoginCloudDataSource {

    suspend fun login(
        username: String,
        password: String
    ): AccessRefreshTokens

    suspend fun refresh(
        refresh: RefreshToken
    ): AccessRefreshTokens

    suspend fun verify(
        token: AccessToken
    )

    class Base(
        private val service: LoginService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), LoginCloudDataSource {

        override suspend fun login(
            username: String,
            password: String
        ) = handle {
            service.login(
                UserCredentials(
                    username = username,
                    password = password
                )
            )
        }

        override suspend fun refresh(
            refresh: RefreshToken
        ) = handle {
            service.refresh(
                refresh = refresh
            )
        }

        override suspend fun verify(
            token: AccessToken
        ) = handle {
            service.verify(
                token = token
            )
        }
    }
}
