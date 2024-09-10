package com.exchange.cloud.websocket.internal

import com.exchange.cloud.websocket.core.WebSocketConnectionEstablish
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

internal class OkHttpWebSocketConnectionEstablish @Inject constructor(
    private val okHttpClient: WebSocket.Factory,
    private val request: Request,
) : WebSocketConnectionEstablish {
    override fun establish(listener: WebSocketListener): WebSocket {
        return okHttpClient.newWebSocket(
            request = request,
            listener = listener
        )
    }
}
