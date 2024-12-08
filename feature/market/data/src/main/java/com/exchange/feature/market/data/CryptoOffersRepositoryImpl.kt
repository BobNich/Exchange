package com.exchange.feature.market.data

import com.exchange.cloud.service.asset.PairsCloudDataSource
import com.exchange.feature.market.domain.CryptoOffer
import com.exchange.feature.market.domain.CryptoOffersRepository
import javax.inject.Inject

class CryptoOffersRepositoryImpl @Inject constructor(
    private val cloudDataSource: PairsCloudDataSource
): CryptoOffersRepository {
    override suspend fun offers(): List<CryptoOffer> {
        return emptyList()
    }
}