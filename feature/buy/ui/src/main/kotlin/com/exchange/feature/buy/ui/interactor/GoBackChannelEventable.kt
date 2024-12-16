package com.exchange.feature.buy.ui.interactor

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Inject


interface GoBackChannelEventable {

    fun read(): ReceiveChannel<Unit>

    suspend fun put(value: Unit)

    class Base @Inject constructor(
    ): GoBackChannelEventable {
        private val channel = Channel<Unit>()

        override fun read() = channel

        override suspend fun put(value: Unit) {
            channel.send(Unit)
        }
    }
}