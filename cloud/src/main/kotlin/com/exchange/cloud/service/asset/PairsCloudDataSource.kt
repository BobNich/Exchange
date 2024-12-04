package com.exchange.cloud.service.asset

import com.exchange.cloud.service.asset.model.AssetPair
import com.exchange.core.network.AbstractCloudDataSource
import com.exchange.core.network.HandleError

interface PairsCloudDataSource {

    suspend fun pairs(): List<AssetPair>

    class Base(
        private val service: PairsService,
        errorHandler: HandleError<Exception, Throwable>
    ) : AbstractCloudDataSource(errorHandler), PairsCloudDataSource {

        override suspend fun pairs() = handle {
            service.pairs()
        }
    }
}
