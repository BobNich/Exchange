package com.exchange.cloud.di

import com.exchange.cloud.websocket.core.WebSocketClient
import com.exchange.cloud.websocket.internal.OkHttpWebSocketClient
import com.exchange.cloud.websocket.internal.OkHttpWebSocketConnectionEstablish
import com.exchange.cloud.websocket.url.DebugUrlProvider
import com.exchange.core.data.cloud.ProvideLoggingInterceptor
import com.exchange.core.data.cloud.ProvideOkHttpClientBuilder
import com.exchange.core.data.cloud.ProvideRequestBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object WebSocketModule {

    @Singleton
    @Provides
    fun provideWebSocketClient(): WebSocketClient {
        return OkHttpWebSocketClient(
            connectionEstablisher = OkHttpWebSocketConnectionEstablish(
                okHttpClient = ProvideOkHttpClientBuilder.AddInterceptor(
                    ProvideLoggingInterceptor.Debug(),
                    ProvideOkHttpClientBuilder.Base(),
                ).httpClientBuilder().build(),
                request = ProvideRequestBuilder.Base(
                    DebugUrlProvider().provideBaseUrl()
                ).requestBuilder().build()
            )
        )
    }
}