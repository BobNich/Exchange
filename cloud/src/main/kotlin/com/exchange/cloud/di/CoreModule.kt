package com.exchange.cloud.di

import com.exchange.cloud.BuildConfig
import com.exchange.cloud.core.converter.JsonConverterFactory
import com.exchange.cloud.core.error.HandleDomainError
import com.exchange.cloud.core.error.HandleHttpError
import com.exchange.cloud.service.DebugUrlProvider
import com.exchange.cloud.service.ReleaseUrlProvider

import com.exchange.core.network.HandleError
import com.exchange.core.network.ProvideBaseUrl
import com.exchange.core.network.ProvideConverterFactory
import com.exchange.core.network.ProvideLoggingInterceptor
import com.exchange.core.network.ProvideOkHttpClientBuilder

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object CoreModule {

    @Provides
    @Singleton
    @CoreHttpClient
    internal fun providesOkHttpClientBuilder(
    ): ProvideOkHttpClientBuilder {
        return ProvideOkHttpClientBuilder.AddInterceptor(
            interceptor = ProvideLoggingInterceptor.Debug(),
            provideOkHttp = ProvideOkHttpClientBuilder.Base()
        )
    }

    @Provides
    @Singleton
    internal fun providesConverterFactoryProvider(
    ): ProvideConverterFactory {
        return JsonConverterFactory()
    }

    @Provides
    @Singleton
    internal fun providesHttpErrorHandle(
    ): HandleError<Exception, Throwable> {
        return HandleDomainError(
            httpError = HandleHttpError()
        )
    }

    @Provides
    @Singleton
    internal fun providesBaseUrlProvider(
    ): ProvideBaseUrl {
        return if (BuildConfig.DEBUG) {
            DebugUrlProvider()
        } else {
            ReleaseUrlProvider()
        }
    }

}
