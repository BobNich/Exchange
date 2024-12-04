package com.exchange.feature.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchange.core.ui.StateFlowWrapper
import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.domain.LoginUseCase
import com.exchange.feature.login.domain.UserLoginForm
import com.exchange.feature.login.ui.interactor.login.LoginInteractor
import com.exchange.feature.login.ui.interactor.password.PasswordUiState
import com.exchange.feature.login.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.login.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.login.ui.interactor.username.UsernameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor<LoginUiState>,
    private val updateUsernameAction: UpdateUsernameInteractor<UsernameUiState>,
    private val updatePasswordAction: UpdatePasswordInteractor<PasswordUiState>,
    private val featureUi: StateFlowWrapper.Mutable<LoginUiState>,
    private val usernameState: StateFlowWrapper.Mutable<UsernameUiState>,
    private val passwordState: StateFlowWrapper.Mutable<PasswordUiState>
) : ViewModel() {
    fun uiState() = featureUi.state()

    fun usernameUiState() = usernameState.state()

    fun passwordUiState() = passwordState.state()

    fun updateUsername(value: String) {
        updateUsernameAction.update(value)
    }

    fun updatePassword(value: String) {
        updatePasswordAction.update(value)
    }

    fun login(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            loginInteractor.login(
                username = username,
                password = password
            )
        }
    }
}
