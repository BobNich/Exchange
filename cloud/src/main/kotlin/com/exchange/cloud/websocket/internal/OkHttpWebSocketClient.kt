package com.exchange.cloud.websocket.internal

import com.exchange.cloud.websocket.core.ConnectionClose
import com.exchange.cloud.websocket.core.WebSocketClient
import com.exchange.cloud.websocket.core.WebSocketConnectionEstablish
import com.exchange.cloud.websocket.core.WebSocketMessage
import com.exchange.cloud.websocket.core.WebSocketState
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import okio.ByteString.Companion.toByteString
import javax.inject.Inject

internal class OkHttpWebSocketClient @Inject constructor(
    private val connectionEstablisher: WebSocketConnectionEstablish
) : WebSocketClient {

    private val listener = WebSocketListener(
        observable = WebSocketStateObservable()
    )

    private val webSocketHolder = OkHttpWebSocketHolder()

    override fun open() = listener.observe()
        .onStart { connectionEstablisher.establish(listener) }
        .onEach { event ->
            when (event) {
                is WebSocketState.OnConnectionOpened -> {
                    webSocketHolder.initiate(
                        webSocket = event.webSocket
                    )
                }

                is WebSocketState.OnConnectionClosing -> {
                    close(ConnectionClose.Normal)
                }

                is WebSocketState.OnConnectionClosed,
                is WebSocketState.OnConnectionFailed -> {
                    webSocketHolder.shutdown()
                }
            }
        }

    override fun send(message: WebSocketMessage): Boolean {
        return when (message) {
            is WebSocketMessage.Text -> {
                webSocketHolder.send(
                    text = message
                        .bytes()
                        .toString()
                )
            }

            is WebSocketMessage.Bytes -> {
                webSocketHolder.send(
                    bytes = message
                        .bytes()
                        .toByteString()
                )
            }
        }
    }

    override fun close(close: ConnectionClose): Boolean {
        return webSocketHolder.close(
            code = close.code(),
            reason = close.reason()
        )
    }

    override fun cancel() {
        webSocketHolder.cancel()
    }
}
