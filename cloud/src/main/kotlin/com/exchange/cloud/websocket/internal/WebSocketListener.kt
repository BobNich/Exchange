package com.exchange.cloud.websocket.internal

import com.exchange.core.data.State
import com.exchange.cloud.websocket.core.WebSocketMessage
import com.exchange.cloud.websocket.core.WebSocketState
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import javax.inject.Inject

internal class WebSocketListener @Inject constructor(
    private val observable: State.Mutable<WebSocketState>
) : WebSocketListener(), State.Observe<WebSocketState> {

    override fun observe() = observable.observe()

    override fun onOpen(
        webSocket: WebSocket,
        response: Response
    ) {
        observable.update(
            WebSocketState.OnConnectionOpened(
                webSocket = webSocket
            )
        )
    }

    override fun onMessage(
        webSocket: WebSocket,
        bytes: ByteString
    ) {
        observable.update(
            WebSocketState.OnMessageReceived(
                message = WebSocketMessage.Bytes(
                    value = bytes
                )
            )
        )
    }

    override fun onMessage(
        webSocket: WebSocket,
        text: String
    ) {
        observable.update(
            WebSocketState.OnMessageReceived(
                message = WebSocketMessage.Text(
                    value = text
                )
            )
        )
    }

    override fun onClosed(
        webSocket: WebSocket,
        code: Int,
        reason: String
    ) {
        observable.update(
            WebSocketState.OnConnectionClosed
        )
    }

    override fun onClosing(
        webSocket: WebSocket,
        code: Int,
        reason: String
    ) {
        observable.update(
            WebSocketState.OnConnectionClosing
        )
    }

    override fun onFailure(
        webSocket: WebSocket,
        t: Throwable,
        response: Response?
    ) {
        observable.update(
            WebSocketState.OnConnectionFailed
        )
    }
}
