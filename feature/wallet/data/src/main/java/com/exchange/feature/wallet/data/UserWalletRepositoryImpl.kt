package com.exchange.feature.wallet.data

import com.exchange.cloud.service.user.ProfileCloudDataSource
import com.exchange.core.domain.UserAsset
import com.exchange.core.domain.UserWallet
import com.exchange.feature.wallet.domain.UserWalletRepository
import javax.inject.Inject


internal class UserWalletRepositoryImpl @Inject constructor(
    private val cloudDataSource: ProfileCloudDataSource
) : UserWalletRepository {
    override suspend fun wallet(): UserWallet {
        val profile = cloudDataSource.profile()
        return UserWallet(
            assets = profile.assets
                .map { cloud ->
                    UserAsset(
                        name = cloud.asset.name,
                        code = cloud.asset.code,
                        amount = cloud.amount
                    )
                }
        )
    }
}
