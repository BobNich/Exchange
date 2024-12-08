package com.exchange.feature.login.ui

import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Flowable
import com.exchange.feature.login.ui.interactor.login.LoginInteractor
import com.exchange.feature.login.ui.interactor.password.PasswordUiState
import com.exchange.feature.login.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.login.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.login.ui.interactor.username.UsernameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor<LoginUiState>,
    private val updateUsernameAction: UpdateUsernameInteractor<UsernameUiState>,
    private val updatePasswordAction: UpdatePasswordInteractor<PasswordUiState>,
    private val featureUi: Flowable.Mutable<LoginUiState>,
    private val usernameState: Flowable.Mutable<UsernameUiState>,
    private val passwordState: Flowable.Mutable<PasswordUiState>,
    dispatchers: DispatchersList
) : BaseViewModel(dispatchers) {

    fun uiState() = featureUi.state()

    fun usernameUiState() = usernameState.state()

    fun passwordUiState() = passwordState.state()

    fun updateUsername(value: String) =
        updateUsernameAction.update(value)

    fun updatePassword(value: String) =
        updatePasswordAction.update(value)

    fun login(
        username: String,
        password: String
    ) = async {
        loginInteractor.login(
            username = username,
            password = password
        )
    }

}
