package com.exchange.cloud.service.buy

import com.exchange.cloud.service.buy.model.BuyOffer
import com.exchange.cloud.service.login.LoginService
import com.exchange.cloud.service.login.model.AccessRefreshTokens
import com.exchange.cloud.service.login.model.AccessToken
import com.exchange.cloud.service.login.model.RefreshToken
import com.exchange.cloud.service.login.model.UserCredentials
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface BuyCloudDataSource {

    suspend fun buy(
        buy: BuyOffer
    )

    class Base(
        private val service: BuyService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), BuyCloudDataSource {

        override suspend fun buy(
            buy: BuyOffer
        ) = handle {
            service.buy(buy)
        }
    }
}
