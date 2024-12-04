package com.exchange.feature.signup.data.di

import com.exchange.cloud.core.ExchangeMakeService
import com.exchange.cloud.di.CoreHttpClient
import com.exchange.cloud.service.register.RegisterCloudDataSource
import com.exchange.cloud.service.register.RegisterService

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
internal object SignupCloudModule {

    @Provides
    @Singleton
    internal fun providesCloudDataSource(
        @CoreHttpClient httpClientBuilder: ProvideOkHttpClientBuilder,
        provideBaseUrl: ProvideBaseUrl,
        converterFactory: ProvideConverterFactory,
        errorHandler: HandleError<Exception, Throwable>,
    ): RegisterCloudDataSource {
        return RegisterCloudDataSource.Base(
            service = ExchangeMakeService(
                retrofitBuilder = ProvideRetrofitBuilder.Base(
                    httpClientBuilder = httpClientBuilder,
                    provideConverterFactory = converterFactory
                ),
                baseUrl = provideBaseUrl
            ).service(
                clazz = RegisterService::class.java
            ),
            errorHandler = errorHandler
        )
    }

}
