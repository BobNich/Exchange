package com.exchange.cloud.websocket.core

import kotlinx.coroutines.flow.Flow

interface WebSocketClient {

    /**
     * Opens the connection and returns a flow of web socket state
     */
    fun open(): Flow<WebSocketState>

    /**
     * Sends a message.
     *
     * @return true if the message is enqueued.
     */
    fun send(message: WebSocketMessage): Boolean

    /**
     * Closes the connection after sending all pending messages.
     *
     * @return true if a graceful shutdown is initiated.
     */
    fun close(close: ConnectionClose): Boolean

    /**
     * Closes the connection and discard all pending messages
     */
    fun cancel()
}
