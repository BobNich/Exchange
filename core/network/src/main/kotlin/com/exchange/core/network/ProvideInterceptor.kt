package com.exchange.core.network

import okhttp3.Interceptor

interface ProvideInterceptor {

    fun interceptor(): Interceptor

}
