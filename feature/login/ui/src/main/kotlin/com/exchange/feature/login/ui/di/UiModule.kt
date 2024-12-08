package com.exchange.feature.login.ui.di

import com.exchange.core.ui.Flowable
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
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
internal object UiModule {

    @Provides
    @ViewModelScoped
    internal fun providesLoginInteractor(
        useCase: LoginUseCase,
        uiMapper: LoginActionState.Mapper<LoginUiState>,
        observable: Flowable.Mutable<LoginUiState>
    ): LoginInteractor<LoginUiState> {
        return LoginInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesLoginStateMapper(
    ): LoginActionState.Mapper<LoginUiState> {
        return LoginStateMapper()
    }

    @Provides
    @ViewModelScoped
    internal fun providesSignupObservable(
    ): Flowable.Mutable<LoginUiState> {
        return LoginStateObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesUpdateUsernameInteractor(
        observable: Flowable.Mutable<UsernameUiState>
    ): UpdateUsernameInteractor<UsernameUiState> {
        return UpdateUsernameInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesUsernameObservable(
    ): Flowable.Mutable<UsernameUiState> {
        return UsernameObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesUpdatePasswordInteractor(
        observable: Flowable.Mutable<PasswordUiState>
    ): UpdatePasswordInteractor<PasswordUiState> {
        return UpdatePasswordInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesPasswordObservable(
    ): Flowable.Mutable<PasswordUiState> {
        return PasswordObservable()
    }
}
