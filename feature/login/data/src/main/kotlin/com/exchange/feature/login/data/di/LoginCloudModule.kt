package com.exchange.feature.login.data.di

import com.exchange.cloud.core.ExchangeMakeService
import com.exchange.cloud.di.CoreHttpClient
import com.exchange.cloud.service.login.LoginCloudDataSource
import com.exchange.cloud.service.login.LoginService

import com.exchange.core.network.HandleError
import com.exchange.core.network.ProvideBaseUrl
import com.exchange.core.network.ProvideConverterFactory
import com.exchange.core.network.ProvideOkHttpClientBuilder
import com.exchange.core.network.ProvideRetrofitBuilder

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object LoginCloudModule {

    @Provides
    @Singleton
    internal fun providesCloudDataSource(
        @CoreHttpClient httpClientBuilder: ProvideOkHttpClientBuilder,
        provideBaseUrl: ProvideBaseUrl,
        converterFactory: ProvideConverterFactory,
        errorHandler: HandleError<Exception, Throwable>,
    ): LoginCloudDataSource {
        return LoginCloudDataSource.Base(
            service = ExchangeMakeService(
                retrofitBuilder = ProvideRetrofitBuilder.Base(
                    httpClientBuilder = httpClientBuilder,
                    provideConverterFactory = converterFactory
                ),
                baseUrl = provideBaseUrl
            ).service(
                clazz = LoginService::class.java
            ),
            errorHandler = errorHandler
        )
    }

}
