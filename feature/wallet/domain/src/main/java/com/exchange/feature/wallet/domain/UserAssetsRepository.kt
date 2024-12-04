package com.exchange.feature.wallet.domain


interface UserAssetsRepository {

    suspend fun assets(): List<UserAsset>

}
