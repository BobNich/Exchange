package com.exchange.feature.market.domain

import com.exchange.core.domain.CryptoOffer

interface CryptoOffersRepository {

    suspend fun offers(): List<CryptoOffer>

}