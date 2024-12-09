package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Resource
import com.exchange.feature.signup.ui.R
import com.exchange.feature.signup.ui.SignupUiState
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject


class SignupChannelEventable @Inject constructor(
    private val resource: Resource,
    private val goBackEvent: Eventable<Unit, Unit>
) : Eventable<SignupUiState, String> {
    private val channel = Channel<String>()

    override fun read() = channel

    override suspend fun put(value: SignupUiState) {
        when (value) {
            is SignupUiState.Failure -> {
                channel.send(value.message)
            }

            is SignupUiState.Success -> {
                channel.send(
                    resource.string(
                        R.string.signup_success_message
                    )
                )
                goBackEvent.put(Unit)
            }

            else -> Unit
        }
    }
}
