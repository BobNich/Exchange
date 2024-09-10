package com.exchange.cloud.websocket.core

import okhttp3.WebSocket
import okhttp3.WebSocketListener

interface WebSocketConnectionEstablish {

    fun establish(listener: WebSocketListener): WebSocket

}