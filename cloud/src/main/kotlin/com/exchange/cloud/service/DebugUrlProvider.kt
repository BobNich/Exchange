package com.exchange.cloud.service

import com.exchange.cloud.BuildConfig
import com.exchange.core.network.ProvideBaseUrl


class DebugUrlProvider: ProvideBaseUrl {
    override fun provideBaseUrl(): String {
        return BuildConfig.DEBUG_EXCHANGE_BACKEND_URL
    }
}
