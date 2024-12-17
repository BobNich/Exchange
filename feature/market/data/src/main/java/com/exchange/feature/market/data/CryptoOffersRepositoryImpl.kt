package com.exchange.feature.market.data

import com.exchange.cloud.service.market.MarketCloudDataSource
import com.exchange.core.domain.CryptoOffer
import com.exchange.feature.market.domain.CryptoOffersRepository
import kotlinx.datetime.Instant
import javax.inject.Inject


class CryptoOffersRepositoryImpl @Inject constructor(
    private val cloudDataSource: MarketCloudDataSource
): CryptoOffersRepository {
    override suspend fun offers(): List<CryptoOffer> {
        return cloudDataSource.orders().map { cloud ->
            CryptoOffer(
                id = cloud.id.toString(),
                sellerUsername = cloud.seller.username,
                price = cloud.price,
                sellAssetCode = cloud.sellAsset.code,
                buyAssetCode = cloud.buyAsset.code,
                minimumAmount = cloud.minAmount,
                maximumAmount = cloud.maxAmount,
                createdAt = Instant.parse(cloud.createdAt).epochSeconds
            )
        }.sortedByDescending { it.createdAt }
    }
}
