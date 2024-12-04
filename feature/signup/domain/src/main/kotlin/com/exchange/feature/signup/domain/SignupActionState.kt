package com.exchange.feature.signup.domain


interface SignupActionState {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun progress(): T

        fun success(): T

        fun failure(message: String): T
    }

    data object Progress : SignupActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.progress()
        }
    }

    data object Success : SignupActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.success()
        }
    }

    data class Failure(
        private val message: String
    ) : SignupActionState {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.failure(message)
        }
    }
}
