package com.exchange.feature.login.domain


interface LoginActionState {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun progress(): T

        fun success(): T

        fun failure(message: String): T
    }


    data object Progress : LoginActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.progress()
        }
    }

    data object Success : LoginActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.success()
        }
    }

    data class Failure(
        private val message: String
    ) : LoginActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.failure(message)
        }
    }
}
