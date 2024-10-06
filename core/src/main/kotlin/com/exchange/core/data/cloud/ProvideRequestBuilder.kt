package com.exchange.core.data.cloud

import okhttp3.Request

interface ProvideRequestBuilder {

    fun requestBuilder(): Request.Builder

    class Base(
        private val url: String
    ) : ProvideRequestBuilder {
        override fun requestBuilder(): Request.Builder {
            return Request.Builder()
                .url(url)
        }
    }
}
