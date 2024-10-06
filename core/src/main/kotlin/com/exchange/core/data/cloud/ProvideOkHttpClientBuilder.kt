package com.exchange.core.data.cloud

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient.Builder

    class Base(
        private val timeoutUnit: TimeUnit = TimeUnit.SECONDS,
        private val timeout: Long = 5L
    ) : ProvideOkHttpClientBuilder {
        override fun httpClientBuilder(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
                .connectTimeout(timeout, timeoutUnit)
                .readTimeout(timeout, timeoutUnit)
                .writeTimeout(timeout, timeoutUnit)
        }
    }

    class AddInterceptor(
        private val interceptor: ProvideInterceptor,
        private val provideOkHttp: ProvideOkHttpClientBuilder
    ) : ProvideOkHttpClientBuilder {
        override fun httpClientBuilder(): OkHttpClient.Builder {
            return provideOkHttp
                .httpClientBuilder()
                .addInterceptor(interceptor.interceptor())
        }
    }
}
