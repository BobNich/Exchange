package com.exchange.feature.buy.data.di

import com.exchange.cloud.service.buy.BuyCloudDataSource
import com.exchange.feature.buy.data.BuyUseCaseImpl
import com.exchange.feature.buy.domain.BuyUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object BuyModule {

    @Provides
    @Singleton
    internal fun providesGetCryptoOffersUseCase(
        cloudDataSource: BuyCloudDataSource
    ): BuyUseCase {
        return BuyUseCaseImpl(
            cloudDataSource = cloudDataSource
        )
    }

}
