package com.exchange.feature.wallet.domain

import com.exchange.core.domain.UserWallet


interface GetUserWalletActionState {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun progress(): T

        fun success(wallet: UserWallet): T

        fun failure(message: String): T
    }


    data object Progress : GetUserWalletActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.progress()
        }
    }

    data class Success(
        private val wallet: UserWallet
    ) : GetUserWalletActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.success(wallet)
        }
    }

    data class Failure(
        private val message: String
    ) : GetUserWalletActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.failure(message)
        }
    }
}
