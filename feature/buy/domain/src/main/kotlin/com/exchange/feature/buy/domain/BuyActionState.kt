package com.exchange.feature.buy.domain


interface BuyActionState {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun progress(): T

        fun success(): T

        fun failure(message: String): T
    }


    data object Progress : BuyActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.progress()
        }
    }

    data object Success : BuyActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.success()
        }
    }

    data class Failure(
        val message: String
    ) : BuyActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.failure(message = message)
        }
    }
}
