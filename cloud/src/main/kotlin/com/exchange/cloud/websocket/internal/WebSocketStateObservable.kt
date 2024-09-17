package com.exchange.cloud.websocket.internal

import com.exchange.core.data.State
import com.exchange.cloud.websocket.core.WebSocketState
import javax.inject.Inject

internal class WebSocketStateObservable @Inject constructor() :
    State.Abstract<WebSocketState>(
        initialState = WebSocketState.Nothing
    )