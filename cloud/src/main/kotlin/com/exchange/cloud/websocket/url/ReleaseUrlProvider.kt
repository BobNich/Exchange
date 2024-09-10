package com.exchange.cloud.websocket.url

import com.exchange.cloud.core.ProvideBaseUrl

class ReleaseUrlProvider : ProvideBaseUrl {
    companion object {
        private const val RELEASE_SERVICE_URL = "wss://exchange.boston.com"
    }

    override fun provideBaseUrl() = RELEASE_SERVICE_URL
}