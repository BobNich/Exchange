package com.exchange.cloud.core.interceptor

import com.exchange.core.network.HeaderInterceptor
import com.exchange.core.network.ProvideToken
import com.exchange.core.network.ProvideInterceptor
import okhttp3.Interceptor


class AuthHeaderInterceptorProvider(
    private val tokenProvider: ProvideToken
) : ProvideInterceptor {
    override fun interceptor(): Interceptor {
        return HeaderInterceptor(
            "Authorization",
            "Bearer ${tokenProvider.provideToken()}"
        )
    }
}
