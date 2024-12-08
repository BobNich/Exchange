package com.exchange.feature.market.ui.di

import com.exchange.core.ui.Flowable
import com.exchange.feature.market.domain.GetCryptoOffersActionState
import com.exchange.feature.market.domain.GetCryptoOffersUseCase
import com.exchange.feature.market.ui.MarketUiState
import com.exchange.feature.market.ui.interactor.CryptoOffersObservable
import com.exchange.feature.market.ui.interactor.CryptoOffersStateMapper
import com.exchange.feature.market.ui.interactor.GetCryptoOffersInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object UiModule {

    @Provides
    @ViewModelScoped
    internal fun providesCryptoOfferObservable(
    ): Flowable.Mutable<MarketUiState> {
        return CryptoOffersObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesGetCryptoOffersActionState(
    ): GetCryptoOffersActionState.Mapper<MarketUiState> {
        return CryptoOffersStateMapper()
    }

    @Provides
    @ViewModelScoped
    internal fun providesGetCryptoOffersInteractor(
        useCase: GetCryptoOffersUseCase,
        uiMapper: GetCryptoOffersActionState.Mapper<MarketUiState>,
        observable: Flowable.Mutable<MarketUiState>
    ): GetCryptoOffersInteractor<MarketUiState> {
        return GetCryptoOffersInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

}