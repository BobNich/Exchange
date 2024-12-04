package com.exchange.cloud.service.user

import com.exchange.cloud.service.user.model.UserProfile
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface ProfileCloudDataSource {

    suspend fun profile(): UserProfile

    class Base(
        private val service: ProfileService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), ProfileCloudDataSource {

        override suspend fun profile() = handle {
            service.profile()
        }
    }
}
