package com.exchange.feature.wallet.domain

import com.exchange.core.domain.UserWallet


interface UserWalletRepository {

    suspend fun wallet(): UserWallet

}
