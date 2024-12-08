package com.exchange.feature.wallet.ui.interactor.username

import com.exchange.core.ui.AbstractStateFlowWrapper
import javax.inject.Inject


class UsernameObservable @Inject constructor(
) : AbstractStateFlowWrapper<String>(
    initialState = ""
)
