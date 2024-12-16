package com.exchange.feature.buy.ui.di

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Resource
import com.exchange.feature.buy.domain.BuyActionState
import com.exchange.feature.buy.domain.BuyUseCase
import com.exchange.feature.buy.ui.BuyUiState
import com.exchange.feature.buy.ui.interactor.BuyChannelEventable
import com.exchange.feature.buy.ui.interactor.BuyOfferInteractor
import com.exchange.feature.buy.ui.interactor.BuyOfferStateMapper
import com.exchange.feature.buy.ui.interactor.GoBackChannelEventable
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
    internal fun providesBuyInteractor(
        useCase: BuyUseCase,
        uiMapper: BuyActionState.Mapper<BuyUiState>,
        eventable: Eventable<BuyUiState, String>
    ): BuyOfferInteractor<BuyUiState, String> {
        return BuyOfferInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            eventable = eventable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesGoBackEventChannel(
    ): GoBackChannelEventable {
        return GoBackChannelEventable.Base()
    }

    @Provides
    @ViewModelScoped
    internal fun providesBuyEventChannel(
        resource: Resource,
        goBackEvent: GoBackChannelEventable
    ): Eventable<BuyUiState, String> {
        return BuyChannelEventable(
            goBack = goBackEvent,
            resource = resource
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesBuyStateMapper(
    ): BuyActionState.Mapper<BuyUiState> {
        return BuyOfferStateMapper()
    }

}
