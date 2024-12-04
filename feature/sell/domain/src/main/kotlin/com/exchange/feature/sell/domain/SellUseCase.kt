package com.exchange.feature.sell.domain

import kotlinx.coroutines.flow.Flow


interface SellUseCase {
    suspend operator fun invoke(request: SellOffer): Flow<SellActionState>
}
