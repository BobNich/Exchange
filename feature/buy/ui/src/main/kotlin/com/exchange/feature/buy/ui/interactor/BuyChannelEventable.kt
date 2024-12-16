package com.exchange.feature.buy.ui.interactor

import com.exchange.core.ui.Eventable
import com.exchange.core.ui.Resource
import com.exchange.feature.buy.ui.BuyUiState
import com.exchange.feature.buy.ui.R
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject


class BuyChannelEventable @Inject constructor(
    private val goBack: GoBackChannelEventable,
    private val resource: Resource,
) : Eventable<BuyUiState, String> {
    private val channel = Channel<String>()

    override fun read() = channel

    override suspend fun put(value: BuyUiState) {
        when (value) {
            is BuyUiState.Failure -> {
                channel.send(value.message)
            }

            is BuyUiState.Success -> {
                channel.send(
                    resource.string(
                        R.string.success_buy_message
                    )
                )
                goBack.put(Unit)
            }

            else -> Unit
        }
    }
}
