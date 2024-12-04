package com.exchange.feature.market.domain


interface GetCryptoOffersUseCase {
    suspend operator fun invoke(): List<CryptoOffer>
}
