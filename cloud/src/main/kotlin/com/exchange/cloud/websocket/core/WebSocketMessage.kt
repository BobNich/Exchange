package com.exchange.cloud.websocket.core

import okio.ByteString

sealed interface WebSocketMessage {

    fun bytes(): ByteArray

    data class Text(
        private val value: String
    ) : WebSocketMessage {
        override fun bytes(): ByteArray {
            return value.toByteArray()
        }
    }

    data class Bytes(
        private val value: ByteString
    ) : WebSocketMessage {
        override fun bytes(): ByteArray {
            return value.toByteArray()
        }
    }
}