package com.exchange.core.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient.Builder

    class Base(
        private val timeOutUnit: TimeUnit = TimeUnit.SECONDS,
        private val timeOut: Long = 5L
    ) : ProvideOkHttpClientBuilder {

        override fun httpClientBuilder() = OkHttpClient.Builder()
            .connectTimeout(timeOut, timeOutUnit)
            .readTimeout(timeOut, timeOutUnit)
    }

    class AddInterceptor(
        private val interceptor: ProvideInterceptor,
        private val provideOkHttp: ProvideOkHttpClientBuilder
    ) : ProvideOkHttpClientBuilder {
        override fun httpClientBuilder(): OkHttpClient.Builder {
            return provideOkHttp.httpClientBuilder().addInterceptor(interceptor.interceptor())
        }
    }

    class AddAuthenticator(
        private val authenticator: ProvideAuthenticator,
        private val provideOkHttp: ProvideOkHttpClientBuilder
    ) : ProvideOkHttpClientBuilder {
        override fun httpClientBuilder(): OkHttpClient.Builder {
            return provideOkHttp.httpClientBuilder().authenticator(authenticator.authenticator())
        }
    }
}
