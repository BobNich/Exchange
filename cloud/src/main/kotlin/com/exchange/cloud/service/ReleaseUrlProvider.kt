package com.exchange.cloud.service

import com.exchange.core.network.ProvideBaseUrl


class ReleaseUrlProvider: ProvideBaseUrl {
    override fun provideBaseUrl(): String {
        return "http://192.168.31.198:8000/api/"
    }
}
