package com.exchange.feature.market.data.di

import com.exchange.cloud.service.market.MarketCloudDataSource
import com.exchange.feature.market.data.CryptoOffersRepositoryImpl
import com.exchange.feature.market.data.GetCryptoOffersUseCaseImpl
import com.exchange.feature.market.domain.CryptoOffersRepository
import com.exchange.feature.market.domain.GetCryptoOffersUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object MarketModule {

    @Provides
    @Singleton
    internal fun providesCryptoOffersRepository(
        cloudDataSource: MarketCloudDataSource
    ): CryptoOffersRepository {
        return CryptoOffersRepositoryImpl(
            cloudDataSource = cloudDataSource
        )
    }

    @Provides
    @Singleton
    internal fun providesGetCryptoOffersUseCase(
        repository: CryptoOffersRepository
    ): GetCryptoOffersUseCase {
        return GetCryptoOffersUseCaseImpl(
            repository = repository
        )
    }

}