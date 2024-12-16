package com.exchange.cloud.service.buy

import com.exchange.cloud.service.buy.model.BuyOffer
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface BuyCloudDataSource {

    suspend fun buy(
        id: String,
        buy: BuyOffer
    )

    class Base(
        private val service: BuyService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), BuyCloudDataSource {

        override suspend fun buy(
            id: String,
            buy: BuyOffer
        ) = handle {
            service.buy(id, buy)
        }
    }
}
