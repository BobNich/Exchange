package com.exchange.feature.market.domain

interface CryptoOffersRepository {

    suspend fun offers(): List<CryptoOffer>

}