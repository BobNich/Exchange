package com.exchange.feature.market.domain


interface GetCryptoOffersActionState {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun progress(): T

        fun success(offers: List<CryptoOffer>): T

        fun failure(message: String): T
    }


    data object Progress : GetCryptoOffersActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.progress()
        }
    }

    data class Success(
        private val offers: List<CryptoOffer>
    ) : GetCryptoOffersActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.success(offers)
        }
    }

    data class Failure(
        private val message: String
    ) : GetCryptoOffersActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.failure(message)
        }
    }
}
