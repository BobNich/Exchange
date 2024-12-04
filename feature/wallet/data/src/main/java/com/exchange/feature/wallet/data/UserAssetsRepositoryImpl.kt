package com.exchange.feature.wallet.data

import com.exchange.cloud.service.user.ProfileCloudDataSource
import com.exchange.feature.wallet.domain.UserAsset
import com.exchange.feature.wallet.domain.UserAssetsRepository
import javax.inject.Inject


internal class UserAssetsRepositoryImpl @Inject constructor(
    private val cloudDataSource: ProfileCloudDataSource
) : UserAssetsRepository {
    override suspend fun assets(): List<UserAsset> {
        return cloudDataSource.profile()
            .assets
            .map { cloud ->
                UserAsset(
                    name = cloud.asset.name,
                    code = cloud.asset.code,
                    amount = cloud.amount
                )
            }
    }
}
