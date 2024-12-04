package com.exchange.feature.login.ui.di

import com.exchange.core.ui.StateFlowWrapper
import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.domain.LoginUseCase
import com.exchange.feature.login.ui.LoginUiState
import com.exchange.feature.login.ui.interactor.login.LoginInteractor
import com.exchange.feature.login.ui.interactor.login.LoginStateMapper
import com.exchange.feature.login.ui.interactor.login.LoginStateObservable
import com.exchange.feature.login.ui.interactor.password.PasswordObservable
import com.exchange.feature.login.ui.interactor.password.PasswordUiState
import com.exchange.feature.login.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.login.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.login.ui.interactor.username.UsernameObservable
import com.exchange.feature.login.ui.interactor.username.UsernameUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object UiModule {

    @Provides
    @Singleton
    internal fun providesLoginInteractor(
        useCase: LoginUseCase,
        uiMapper: LoginActionState.Mapper<LoginUiState>,
        observable: StateFlowWrapper.Mutable<LoginUiState>
    ): LoginInteractor<LoginUiState> {
        return LoginInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesLoginStateMapper(
    ): LoginActionState.Mapper<LoginUiState> {
        return LoginStateMapper()
    }

    @Provides
    @Singleton
    internal fun providesSignupObservable(
    ): StateFlowWrapper.Mutable<LoginUiState> {
        return LoginStateObservable()
    }

    @Provides
    @Singleton
    internal fun providesUpdateUsernameInteractor(
        observable: StateFlowWrapper.Mutable<UsernameUiState>
    ): UpdateUsernameInteractor<UsernameUiState> {
        return UpdateUsernameInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesUsernameObservable(
    ): StateFlowWrapper.Mutable<UsernameUiState> {
        return UsernameObservable()
    }

    @Provides
    @Singleton
    internal fun providesUpdatePasswordInteractor(
        observable: StateFlowWrapper.Mutable<PasswordUiState>
    ): UpdatePasswordInteractor<PasswordUiState> {
        return UpdatePasswordInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesPasswordObservable(
    ): StateFlowWrapper.Mutable<PasswordUiState> {
        return PasswordObservable()
    }
}
