package com.exchange.feature.wallet.domain

import kotlinx.coroutines.flow.Flow


interface GetUserAssetsUseCase {
    suspend operator fun invoke(): Flow<GetUserAssetsActionState>
}
