package com.exchange.feature.settings.ui

import com.exchange.core.ui.BaseViewModel
import com.exchange.core.ui.DispatchersList
import com.exchange.feature.settings.domain.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    dispatchers: DispatchersList
) : BaseViewModel(dispatchers) {

    fun logout() = async {
        logoutUseCase()
    }

}
