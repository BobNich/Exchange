package com.exchange.cloud.core.interceptor

import com.exchange.core.network.HeaderInterceptor
import com.exchange.core.network.ProvideInterceptor
import com.exchange.core.network.ProvideToken
import okhttp3.Interceptor


class AuthHeaderInterceptorProvider(
    private val tokenProvider: ProvideToken
) : ProvideInterceptor {
    override fun interceptor(): Interceptor {
        return HeaderInterceptor(
            "Authorization"
        ) {
            val accessToken = runCatching {
                tokenProvider.provideToken()
            }.getOrNull()
            "Bearer $accessToken"
        }
    }
}
