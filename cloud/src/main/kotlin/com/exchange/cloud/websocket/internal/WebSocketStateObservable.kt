package com.exchange.cloud.websocket.internal

import com.exchange.cloud.core.StateTunnel
import com.exchange.cloud.websocket.core.WebSocketState
import javax.inject.Inject

internal class WebSocketStateObservable @Inject constructor() :
    StateTunnel.Abstract<WebSocketState>(
        initialState = WebSocketState.Nothing
    )