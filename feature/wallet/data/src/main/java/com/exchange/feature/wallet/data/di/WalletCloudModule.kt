package com.exchange.feature.wallet.data.di

import com.exchange.account.UserAccount

import com.exchange.cloud.core.ExchangeMakeService
import com.exchange.cloud.core.auth.OAuthAuthenticator
import com.exchange.cloud.core.interceptor.AuthHeaderInterceptorProvider
import com.exchange.cloud.core.token.ProvideAccessToken
import com.exchange.cloud.core.token.ProvideRefreshToken
import com.exchange.cloud.di.CoreHttpClient
import com.exchange.cloud.service.asset.PairsCloudDataSource
import com.exchange.cloud.service.asset.PairsService
import com.exchange.cloud.service.login.LoginCloudDataSource

import com.exchange.core.network.HandleError
import com.exchange.core.network.ProvideAuthenticator
import com.exchange.core.network.ProvideBaseUrl
import com.exchange.core.network.ProvideConverterFactory
import com.exchange.core.network.ProvideOkHttpClientBuilder
import com.exchange.core.network.ProvideRetrofitBuilder

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object WalletCloudModule {

    @Provides
    @Singleton
    @WalletHttpClient
    internal fun providesOkHttpClient(
        @CoreHttpClient coreHttpClient: ProvideOkHttpClientBuilder,
        loginCloudDataSource: LoginCloudDataSource,
        userAccount: UserAccount
    ): ProvideOkHttpClientBuilder {
        return ProvideOkHttpClientBuilder.AddAuthenticator(
            authenticator = object : ProvideAuthenticator {
                override fun authenticator(): Authenticator {
                    return OAuthAuthenticator(
                        provideRefreshToken = ProvideRefreshToken(userAccount),
                        loginCloudDataSource = loginCloudDataSource,
                        userAccount = userAccount
                    )
                }
            },
            provideOkHttp = ProvideOkHttpClientBuilder.AddInterceptor(
                interceptor = AuthHeaderInterceptorProvider(
                    tokenProvider = ProvideAccessToken(userAccount)
                ),
                provideOkHttp = coreHttpClient
            )
        )
    }

    @Provides
    @Singleton
    internal fun providesCloudDataSource(
        @WalletHttpClient httpClientBuilder: ProvideOkHttpClientBuilder,
        provideBaseUrl: ProvideBaseUrl,
        converterFactory: ProvideConverterFactory,
        errorHandler: HandleError<Exception, Throwable>,
    ): PairsCloudDataSource {
        return PairsCloudDataSource.Base(
            service = ExchangeMakeService(
                retrofitBuilder = ProvideRetrofitBuilder.Base(
                    httpClientBuilder = httpClientBuilder,
                    provideConverterFactory = converterFactory
                ),
                baseUrl = provideBaseUrl
            ).service(
                clazz = PairsService::class.java
            ),
            errorHandler = errorHandler
        )
    }

}
