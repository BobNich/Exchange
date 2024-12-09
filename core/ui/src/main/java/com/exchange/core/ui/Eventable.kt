package com.exchange.core.ui

import kotlinx.coroutines.channels.ReceiveChannel

interface Eventable<F, T> {

    fun read(): ReceiveChannel<T>

    suspend fun put(value: F)

}