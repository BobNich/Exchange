package com.exchange.feature.wallet.ui.di

import com.exchange.core.ui.Flowable
import com.exchange.feature.wallet.domain.GetUserWalletActionState
import com.exchange.feature.wallet.domain.GetUserWalletUseCase
import com.exchange.feature.wallet.domain.GetUsernameUseCase
import com.exchange.feature.wallet.ui.interactor.username.GetUsernameInteractor
import com.exchange.feature.wallet.ui.interactor.username.UsernameObservable
import com.exchange.feature.wallet.ui.interactor.wallet.GetUserWalletInteractor
import com.exchange.feature.wallet.ui.interactor.wallet.UserWalletStateMapper
import com.exchange.feature.wallet.ui.interactor.wallet.WalletObservable
import com.exchange.feature.wallet.ui.interactor.wallet.WalletUiState

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
    internal fun providesGetUserWalletInteractor(
        useCase: GetUserWalletUseCase,
        uiMapper: GetUserWalletActionState.Mapper<WalletUiState>,
        observable: Flowable.Mutable<WalletUiState>
    ): GetUserWalletInteractor<WalletUiState> {
        return GetUserWalletInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesUserWalletStateMapper(
    ): GetUserWalletActionState.Mapper<WalletUiState> {
        return UserWalletStateMapper()
    }

    @Provides
    @ViewModelScoped
    internal fun providesWalletObservable(
    ): Flowable.Mutable<WalletUiState> {
        return WalletObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesGetUsernameInteractor(
        useCase: GetUsernameUseCase,
        observable: Flowable.Mutable<String>
    ): GetUsernameInteractor<String> {
        return GetUsernameInteractor.Base(
            useCase = useCase,
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesUsernameObservable(
    ): Flowable.Mutable<String> {
        return UsernameObservable()
    }

}
