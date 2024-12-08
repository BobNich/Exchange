package com.exchange.cloud.service

import com.exchange.cloud.BuildConfig
import com.exchange.core.network.ProvideBaseUrl


class ReleaseUrlProvider: ProvideBaseUrl {
    override fun provideBaseUrl(): String {
        return BuildConfig.PROD_EXCHANGE_BACKEND_PURL
    }
}
