package com.exchange.feature.login.ui.interactor.login

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Resource
import com.exchange.feature.login.ui.LoginUiState
import com.exchange.feature.login.ui.R
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject


class LoginChannelEventable @Inject constructor(
    private val resource: Resource
) : Eventable<LoginUiState, String> {
    private val channel = Channel<String>()

    override fun read() = channel

    override suspend fun put(value: LoginUiState) {
        when (value) {
            is LoginUiState.Failure -> {
                channel.send(value.message)
            }

            is LoginUiState.Success -> {
                channel.send(
                    resource.string(
                        R.string.login_success_message
                    )
                )
            }

            else -> Unit
        }
    }
}
