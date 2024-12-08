package com.exchange.feature.wallet.domain

import kotlinx.coroutines.flow.Flow


interface GetUserWalletUseCase {
    suspend operator fun invoke(): Flow<GetUserWalletActionState>
}
