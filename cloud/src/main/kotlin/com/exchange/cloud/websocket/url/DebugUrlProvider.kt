package com.exchange.cloud.websocket.url

import com.exchange.cloud.core.ProvideBaseUrl

class DebugUrlProvider : ProvideBaseUrl {
    companion object {
        private const val DEBUG_SERVICE_URL = "ws://0.0.0.0:8000"
    }

    override fun provideBaseUrl() = DEBUG_SERVICE_URL
}