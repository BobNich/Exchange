package com.exchange.feature.signup.ui.interactor.username

import com.exchange.core.ui.AbstractStateFlowWrapper
import javax.inject.Inject


class UsernameObservable @Inject constructor(
) : AbstractStateFlowWrapper<UsernameUiState>(
    initialState = UsernameUiState.Initial
)
