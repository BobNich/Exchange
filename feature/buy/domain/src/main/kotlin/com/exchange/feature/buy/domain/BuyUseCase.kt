package com.exchange.feature.buy.domain

import kotlinx.coroutines.flow.Flow


interface BuyUseCase {
    suspend operator fun invoke(
        request: BuyRequest
    ): Flow<BuyActionState>
}
