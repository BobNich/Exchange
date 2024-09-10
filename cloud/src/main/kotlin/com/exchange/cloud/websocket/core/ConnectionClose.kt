package com.exchange.cloud.websocket.core

interface ConnectionClose {

    fun code(): Int

    fun reason(): String

    abstract class Abstract(
        private val code: Int,
        private val reason: String
    ) : ConnectionClose {
        override fun code() = code

        override fun reason() = reason
    }

    data object Normal : Abstract(
        code = 1000,
        reason = "Normal closure"
    )

    data class Other(
        private val code: Int,
        private val reason: String
    ) : Abstract(
        code = code,
        reason = reason
    )
}