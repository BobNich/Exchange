package com.exchange.cloud.websocket.core

import okhttp3.WebSocket

interface WebSocketState {
    data object Nothing : WebSocketState

    data class OnConnectionOpened(
        val webSocket: WebSocket
    ) : WebSocketState

    data class OnMessageReceived(
        val message: WebSocketMessage
    ) : WebSocketState

    data object OnConnectionClosing : WebSocketState

    data object OnConnectionClosed : WebSocketState

    data object OnConnectionFailed : WebSocketState
}
