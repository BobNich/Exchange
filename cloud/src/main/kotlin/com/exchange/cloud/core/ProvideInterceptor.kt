package com.exchange.cloud.core

import okhttp3.Interceptor

interface ProvideInterceptor {

    fun interceptor(): Interceptor

}
