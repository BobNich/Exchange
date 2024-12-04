package com.exchange.feature.login.ui.interactor.login

import com.exchange.core.ui.AbstractStateFlowWrapper
import com.exchange.feature.login.ui.LoginUiState
import javax.inject.Inject


class LoginStateObservable @Inject constructor(
) : AbstractStateFlowWrapper<LoginUiState>(
    initialState = LoginUiState.Initial
)
