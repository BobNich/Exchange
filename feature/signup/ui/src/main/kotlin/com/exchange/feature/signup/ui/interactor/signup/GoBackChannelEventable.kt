package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.core.ui.Eventable
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class GoBackChannelEventable @Inject constructor(
): Eventable<Unit, Unit> {
    private val channel = Channel<Unit>()

    override fun read() = channel

    override suspend fun put(value: Unit) {
        channel.send(Unit)
    }
}