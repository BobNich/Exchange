package com.exchange.cloud.service.register

import com.exchange.cloud.service.login.model.UserCredentials
import com.exchange.cloud.service.register.model.RegistrationConfirm
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface RegisterCloudDataSource {

    suspend fun register(
        username: String,
        password: String
    ): RegistrationConfirm

    class Base(
        private val service: RegisterService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), RegisterCloudDataSource {

        override suspend fun register(
            username: String,
            password: String
        ) = handle {
            service.register(
                UserCredentials(
                    username = username,
                    password = password
                )
            )
        }
    }
}
