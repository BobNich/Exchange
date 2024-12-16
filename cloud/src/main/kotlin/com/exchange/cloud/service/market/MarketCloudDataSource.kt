package com.exchange.cloud.service.market

import com.exchange.cloud.service.market.model.Offer
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError


interface MarketCloudDataSource {

    suspend fun orders(): List<Offer>

    class Base(
        private val service: MarketService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), MarketCloudDataSource {

        override suspend fun orders() = handle {
            service.orders()
        }
    }
}
