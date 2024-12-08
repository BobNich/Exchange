package com.exchange.feature.wallet.domain


interface UserWalletRepository {

    suspend fun wallet(): UserWallet

}
