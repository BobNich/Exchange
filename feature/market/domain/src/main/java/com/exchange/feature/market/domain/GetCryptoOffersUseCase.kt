package com.exchange.feature.market.domain

import kotlinx.coroutines.flow.Flow


interface GetCryptoOffersUseCase {
    suspend operator fun invoke(): Flow<GetCryptoOffersActionState>
}
