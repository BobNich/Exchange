package com.exchange.feature.login.ui.interactor.password

import com.exchange.core.ui.AbstractStateFlowWrapper
import javax.inject.Inject

class PasswordObservable @Inject constructor(
) : AbstractStateFlowWrapper<PasswordUiState>(
    initialState = PasswordUiState.Initial
)