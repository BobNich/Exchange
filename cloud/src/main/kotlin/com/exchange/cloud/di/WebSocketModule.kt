package com.exchange.cloud.di

import com.exchange.cloud.core.ProvideLoggingInterceptor
import com.exchange.cloud.core.ProvideOkHttpClientBuilder
import com.exchange.cloud.core.ProvideRequestBuilder
import com.exchange.cloud.websocket.core.WebSocketClient
import com.exchange.cloud.websocket.internal.OkHttpWebSocketClient
import com.exchange.cloud.websocket.internal.OkHttpWebSocketConnectionEstablish
import com.exchange.cloud.websocket.url.DebugUrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WebSocketModule {

    @Singleton
    @Provides
    fun provideWebSocketClient(): WebSocketClient {
        return OkHttpWebSocketClient(
            connectionEstablisher = OkHttpWebSocketConnectionEstablish(
                okHttpClient = ProvideOkHttpClientBuilder.Base()
                    .httpClientBuilder()
                    .addInterceptor(
                        ProvideLoggingInterceptor
                            .Debug()
                            .interceptor()
                    )
                    .build(),
                request = ProvideRequestBuilder.Base(
                    DebugUrlProvider().provideBaseUrl()
                ).requestBuilder().build()
            )
        )
    }
}