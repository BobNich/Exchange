package com.exchange.feature.signup.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchange.core.ui.StateFlowWrapper
import com.exchange.feature.signup.ui.interactor.password.PasswordUiState
import com.exchange.feature.signup.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.signup.ui.interactor.signup.SignupInteractor
import com.exchange.feature.signup.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.signup.ui.interactor.username.UsernameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignupViewModel @Inject constructor(
    // actions section
    private val signupAction: SignupInteractor<SignupUiState>,
    private val updateUsernameAction: UpdateUsernameInteractor<UsernameUiState>,
    private val updatePasswordAction: UpdatePasswordInteractor<PasswordUiState>,
    // ui states section
    private val featureUi: StateFlowWrapper.Mutable<SignupUiState>,
    private val usernameUi: StateFlowWrapper.Mutable<UsernameUiState>,
    private val passwordUi: StateFlowWrapper.Mutable<PasswordUiState>
) : ViewModel() {
    fun uiState(): StateFlow<SignupUiState> {
        return featureUi.state()
    }

    fun usernameUiState(): StateFlow<UsernameUiState> {
        return usernameUi.state()
    }

    fun passwordUiState(): StateFlow<PasswordUiState> {
        return passwordUi.state()
    }

    fun updateUsername(value: String) {
        updateUsernameAction.update(value)
    }

    fun updatePassword(value: String) {
        updatePasswordAction.update(value)
    }

    fun signup(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            signupAction.signup(
                username = username,
                password = password
            )
        }
    }
}
