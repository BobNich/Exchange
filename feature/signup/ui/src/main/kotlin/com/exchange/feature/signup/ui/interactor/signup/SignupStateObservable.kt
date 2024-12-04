package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.core.ui.AbstractStateFlowWrapper
import com.exchange.feature.signup.ui.SignupUiState
import javax.inject.Inject


class SignupStateObservable @Inject constructor(
) : AbstractStateFlowWrapper<SignupUiState>(
    initialState = SignupUiState.Initial
)
