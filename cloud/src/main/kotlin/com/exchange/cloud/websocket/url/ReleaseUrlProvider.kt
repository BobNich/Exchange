package com.exchange.cloud.websocket.url

import com.exchange.core.data.cloud.ProvideBaseUrl

class ReleaseUrlProvider : ProvideBaseUrl {
    companion object {
        private const val RELEASE_SERVICE_URL = "wss://exchange.boston.com"
    }

    override fun provideBaseUrl() = RELEASE_SERVICE_URL
}