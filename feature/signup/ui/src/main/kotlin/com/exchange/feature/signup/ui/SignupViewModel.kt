package com.exchange.feature.signup.ui

import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Flowable
import com.exchange.feature.signup.ui.interactor.password.PasswordUiState
import com.exchange.feature.signup.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.signup.ui.interactor.signup.SignupInteractor
import com.exchange.feature.signup.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.signup.ui.interactor.username.UsernameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupAction: SignupInteractor<SignupUiState, String>,
    private val updateUsernameAction: UpdateUsernameInteractor<UsernameUiState>,
    private val updatePasswordAction: UpdatePasswordInteractor<PasswordUiState>,
    private val featureUi: Flowable.Mutable<SignupUiState>,
    private val usernameUi: Flowable.Mutable<UsernameUiState>,
    private val passwordUi: Flowable.Mutable<PasswordUiState>,
    private val eventChannel: Eventable<SignupUiState, String>,
    private val goBackEventChannel: Eventable<Unit, Unit>,
    dispatchers: DispatchersList
) : BaseViewModel(dispatchers) {

    fun uiState() = featureUi.state()

    fun usernameUiState() = usernameUi.state()

    fun passwordUiState() = passwordUi.state()

    fun toastEventChannel() = eventChannel.read()

    fun goBackEventChannel() = goBackEventChannel.read()

    fun updateUsername(value: String) =
        updateUsernameAction.update(value)

    fun updatePassword(value: String) =
        updatePasswordAction.update(value)

    fun signup(
        username: String,
        password: String
    ) = async {
        signupAction.signup(
            username = username,
            password = password
        )
    }

}
